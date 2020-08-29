package com.aye.commons.dto;


public class ResultDTO {

    public static CR<?> create(){
        return new CR<>();
    }

    public static CR<?> create(Object data, int code){
        return new CR<>(data, code);
    }

    public static CR<?> create(Object data){
        return new CR<>(data);
    }

    public static QR createQR(QueryData<?> queryData){
        return new QR(queryData);
    }
}
