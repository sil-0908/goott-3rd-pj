package com.goott.pj3.common.util;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3Client;
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
@Service
public class S3FileUploadService {

    @Autowired
    private final AmazonS3Client amazonS3Client;
    @Value("${aws.s3.bucket}")
    private String bucket;
    @Value("${aws.s3.bucket.url}")
    private String defaultUrl;

    List<String> urlList = new ArrayList<>();

    public S3FileUploadService(AmazonS3Client amazonS3Client) {
        this.amazonS3Client = amazonS3Client;
    }

    public List<String> upload(List<MultipartFile> uploadFile) throws IOException {
        //파일이름 새로만들어서 리스트에 담기
        List<Map<String, String>> fileList = new ArrayList<>();
        for (int i = 0; i < uploadFile.size(); i++) {
            String origName = uploadFile.get(i).getOriginalFilename();
            String ext = origName.substring(origName.lastIndexOf('.'));
            String saveFileName = getUuid() + ext;
            Map<String, String> map = new HashMap<>();
            map.put("saveFile", saveFileName);
            fileList.add(map);
        }

        for (int i = 0; i < uploadFile.size(); i++) {
            String url = "";
            File file = new File(System.getProperty("user.dir") + fileList.get(i).get("saveFile"));
            uploadFile.get(i).transferTo(file);
            uploadOnS3(fileList.get(i).get("saveFile"), file);
            url = defaultUrl + '/' + fileList.get(i).get("saveFile");
            urlList.add(url);
            file.delete();
        }
        return urlList;
    }

    private static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

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

}
