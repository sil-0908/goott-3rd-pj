package com.goott.pj3.common.util;

public class AwsS3 {
    private String key;
    private String path;

    public AwsS3(String key, String path) {
        this.key = key;
        this.path = path;
    }

    public String getKey() {
        return key;
    }

    public String getPath() {
        return path;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
