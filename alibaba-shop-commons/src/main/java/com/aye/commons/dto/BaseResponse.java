package com.aye.commons.dto;

import com.aye.commons.ex.enums.CommonErrorEnum;
import com.aye.commons.ex.enums.IErrorEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class BaseResponse implements Serializable {

    /**
     * 当前返回的时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime timestamp;

    /**
     * 业务编码
     */
    protected int code;

    /**
     * 业务 message
     */
    protected String message;

    public BaseResponse() {
//        this.timestamp = LocalDateTime.now();
//        this.code = SUCCESS.getCode();
//        this.message = SUCCESS.getMessage();
        this(CommonErrorEnum.SUCCESS);
    }

    public BaseResponse(IErrorEnum errorEnum) {
//        this.timestamp = LocalDateTime.now();
//        this.code = errorEnum.getCode();
//        if(code != 0){
//            this.message = "failed";
//        }
        this(errorEnum.getCode(), errorEnum.getMessage());
    }

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public int getCode() {
        return code;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
