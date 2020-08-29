package com.aye.commons.exception;


public enum CommonResponseEnum implements IBizErrorEnum {

    SERVER_ERROR(500, "服务器异常");
    int code;
    String message;

    CommonResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
