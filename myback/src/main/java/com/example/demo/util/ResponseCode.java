package com.example.demo.util;

/**
 * 定义响应的状态码
 */
public enum ResponseCode {
    SUCCESS(200,"SUCCESS"),
    ERROR(400,"ERROR"),
    NEED_LOG(2,"NEED_LOG");
    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
