package com.aye.commons.ex.exception;

import com.aye.commons.ex.enums.IErrorEnum;
import lombok.Getter;

/**
 * @ClassName BaseException
 * @Description 异常基类
 * @Author Aye
 * @Date 2020/9/1 11:57
 * @Version 1.0
 */
@Getter
public class BaseException extends RuntimeException {


    /**
     * 返回码
     */
    protected IErrorEnum errorEnum;
    /**
     * 异常消息参数
     */
    protected Object[] args;

    public BaseException(IErrorEnum errorEnum) {
        super(errorEnum.getMessage());
        this.errorEnum = errorEnum;
    }

    public BaseException(int code, String msg) {
        super(msg);
        this.errorEnum = new IErrorEnum() {
            @Override
            public int getCode() {
                return code;
            }

            @Override
            public String getMessage() {
                return msg;
            }
        };
    }

    public BaseException(IErrorEnum errorEnum, Object[] args, String message) {
        super(message);
        this.errorEnum = errorEnum;
        this.args = args;
    }

    public BaseException(IErrorEnum errorEnum, Object[] args, String message, Throwable cause) {
        super(message, cause);
        this.errorEnum = errorEnum;
        this.args = args;
    }

}