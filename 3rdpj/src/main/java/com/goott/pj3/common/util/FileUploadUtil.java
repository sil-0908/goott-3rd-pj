package com.goott.pj3.common.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
//2023.04.09 길영준
// 파일 업로드 클래스 테스트
public class FileUploadUtil {
    private final MultipartFile file;
    private final String savePath;
    private final String filename;
    private final String newFilename;
    private final String extension;
    private boolean newFileFlag = false;

    public FileUploadUtil(String savePath, MultipartFile file, String filename) {
        this.file = file;
        this.filename = filename;
        this.savePath = savePath;
        this.extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        this.newFilename = filename + "_" + UUID.randomUUID() + extension;
    }

    public String getNewFilename() {
        return newFilename;
    }

    public boolean newFile() throws IOException {
        File destFile = new File(savePath, newFilename);
        try {
            file.transferTo(destFile);
            newFileFlag = true;
        } catch (IllegalStateException | IOException e) {
            throw new IOException("Failed to save file to disk", e);
        }
        return newFileFlag;
    }
}
