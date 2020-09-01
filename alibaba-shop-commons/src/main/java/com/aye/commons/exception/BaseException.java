//package com.aye.commons.exception;
//
//
//public class BaseException extends RuntimeException {
//
//    private IBizErrorEnum bizErrorEnum;
//
//    private int code;
//
//    private String msg;
//
//
//    public BaseException() {
//    }
//
//    public BaseException(IBizErrorEnum bizErrorEnum){
//        this(bizErrorEnum, null, null, null);
//    }
//
//    public BaseException(IBizErrorEnum iBizErrorEnum, Object[] args, String msg) {
//        this(iBizErrorEnum, args, msg, null);
//    }
//
//    public BaseException(IBizErrorEnum responseEnum, Object[] args, String message, Throwable cause) {
//        super(message,cause);
//        this.bizErrorEnum = responseEnum;
//        this.msg = responseEnum.getMessage();
//        this.code = responseEnum.getCode();
//    }
//
//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public IBizErrorEnum getBizErrorEnum() {
//        return bizErrorEnum;
//    }
//}
