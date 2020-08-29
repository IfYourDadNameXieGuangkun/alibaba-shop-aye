package com.aye.commons.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

import static com.aye.commons.exception.BizErrorEnum.SUCCESS_CODE;


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
        this.timestamp = LocalDateTime.now();
        this.code = SUCCESS_CODE.getCode();
        this.message = SUCCESS_CODE.getMessage();
    }

    public BaseResponse(int code) {
        this.timestamp = LocalDateTime.now();
        this.code = code;
        if(code != 0){
            this.message = "failed";
        }
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
