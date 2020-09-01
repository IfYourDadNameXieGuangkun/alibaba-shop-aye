//package com.aye.commons.exception;
//
//
//import org.springframework.http.HttpStatus;
//
//
//public enum ServletResponseEnum implements IBizErrorEnum {
//    NoHandlerFoundException(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()),
//    HttpRequestMethodNotSupportedException(HttpStatus.METHOD_NOT_ALLOWED.value(), HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase()),
//    HttpMediaTypeNotSupportedException(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), HttpStatus.UNSUPPORTED_MEDIA_TYPE.getReasonPhrase()),
//    MissingPathVariableException(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()),
//    MissingServletRequestParameterException(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()),
//    TypeMismatchException(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()),
//    HttpMessageNotReadableException(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()),
//    HttpMessageNotWritableException(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()),
//    HttpMediaTypeNotAcceptableException(HttpStatus.NOT_ACCEPTABLE.value(), HttpStatus.NOT_ACCEPTABLE.getReasonPhrase()),
//    ServletRequestBindingException(HttpStatus.NOT_ACCEPTABLE.value(), HttpStatus.NOT_ACCEPTABLE.getReasonPhrase()),
//    ConversionNotSupportedException(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()),
//    MissingServletRequestPartException(HttpStatus.NOT_ACCEPTABLE.value(), HttpStatus.NOT_ACCEPTABLE.getReasonPhrase()),
//    AsyncRequestTimeoutException(HttpStatus.SERVICE_UNAVAILABLE.value(), HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase()),
//    ;
//    int code;
//    String message;
//
//    ServletResponseEnum(int code, String message) {
//        this.code = code;
//        this.message = message;
//    }
//
//    public int getCode() {
//        return code;
//    }
//
//    @Override
//    public String getMessage() {
//        return this.message;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//}
