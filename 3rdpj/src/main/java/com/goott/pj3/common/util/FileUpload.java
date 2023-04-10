package com.goott.pj3.common.util;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class FileUpload {

    // 2023.04.09 길영준
    // 공통으로 사용하게될 파일 업로드 메소드
    // 파일 저장소 확인 후 uploadDir 파라미터 변경 적용 가능.
    public static String saveFile(String uploadDir, MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        // cleanPath=지정경로 이름 정리(백슬래시 -> 슬래시, 상대경로 차단)
        String originalFileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename(), "파일 null"));
        String uniqueFileName = generateUniqueFileName(originalFileName);
        Path filePath = uploadPath.resolve(uniqueFileName);
        multipartFile.transferTo(filePath);

        return uniqueFileName;
    }

    // 파일명 유니크하게 바꾸는 메소드
    private static String generateUniqueFileName(String originalFileName) {
        String uuid = UUID.randomUUID().toString();
        String date = LocalDate.now().toString();
        String fileExtension = getFileExtension(originalFileName);

        String sanitizedOriginalFileName = StringUtils.cleanPath(originalFileName);
        String baseName = StringUtils.getFilename(sanitizedOriginalFileName);

        return String.format("%s_%s_%s%s", uuid, date, baseName, fileExtension);
    }

    // 유효성 검사를 위한 확장자명 추출 메소드
    private static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.'); // 마지막으로 '.' 이 존재하는 위치의 인덱스값
        if (dotIndex < 0) {
            return ""; //어떻게 처리할지 고민좀..
        }

        return fileName.substring(dotIndex); // .포함 확장자명 리턴
    }

}
