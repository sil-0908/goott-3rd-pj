package com.goott.pj3.common.util.aws;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

//2023.04.16 길영준 S3 단일업로드
//2023.04.19 길영준 S3 다중업로드로 변경
//2023.04.26 길영준 S3 주석 추가
@Service
public class S3FileUploadService {

    @Autowired
    private final AmazonS3Client amazonS3Client; //아마존 계정정보 propertie파일 -> common-context에서 주입
    @Value("${aws.s3.bucket}")
    private String bucket; //S3버킷정보
    @Value("${aws.s3.bucket.url}") //지역정보
    private String defaultUrl;

    List<String> urlList = new ArrayList<>(); //업로드된 url을 받기위한 리스트

    public S3FileUploadService(AmazonS3Client amazonS3Client) {
        this.amazonS3Client = amazonS3Client;
    }

    //생성자 주입
    public List<String> upload(List<MultipartFile> uploadFile) throws IOException {
        //파일이름 새로만들어서 리스트에 담기
        List<Map<String, String>> fileList = new ArrayList<>();
        for (int i = 0; i < uploadFile.size(); i++) {
            String origName = uploadFile.get(i).getOriginalFilename(); //원 파일이름
            String ext = origName.substring(origName.lastIndexOf('.')); // 확장자
            String saveFileName = getUuid() + ext; //uuid로 새이름 만들기
            Map<String, String> map = new HashMap<>();
            map.put("saveFile", saveFileName);
            fileList.add(map);
        }

        for (int i = 0; i < uploadFile.size(); i++) {
            String url = "";
            File file = new File(System.getProperty("user.dir") + fileList.get(i).get("saveFile"));
            //로컬 현재위치에 임시저장 객체 만듬
            uploadFile.get(i).transferTo(file); //로컬에 파일 임시저장
            uploadOnS3(fileList.get(i).get("saveFile"), file); //업로드
            url = defaultUrl + '/' + fileList.get(i).get("saveFile"); //업로드한 파일의 url주소
            urlList.add(url); //리턴을 위해 담음
            file.delete(); // 임시파일 삭제
        }
        return urlList; //업로드 후 리턴값 (List<String> 타입)
    }

    // UUID만드는 메소드(중간의-는 지워줌)
    private static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    //S3업로드 메소드
    private void uploadOnS3(final String findName, final File file) {
        // AWS S3 전송 객체 생성
        final TransferManager transferManager = new TransferManager(this.amazonS3Client);
        // 요청 객체 생성
        final PutObjectRequest request = new PutObjectRequest(bucket, findName, file);
        // 업로드 시도
        final Upload upload = transferManager.upload(request);

        try {
            upload.waitForCompletion();
        } catch (AmazonClientException | InterruptedException amazonClientException) {
            amazonClientException.printStackTrace();
        }
    }

    public void deleteFromS3(final String findName) {
        String realFileName = findName.substring(53);
        // 삭제할 객체 생성
        final DeleteObjectRequest deleteRequest = new DeleteObjectRequest(bucket, realFileName);
        // 삭제
        this.amazonS3Client.deleteObject(deleteRequest);
    }

}
