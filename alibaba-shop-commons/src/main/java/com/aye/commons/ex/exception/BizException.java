package com.aye.commons.ex.exception;

import com.aye.commons.ex.enums.IErrorEnum;

/**
 * @ClassName BizException
 * @Description 业务异常处理
 * @Author Aye
 * @Date 2020/9/1 14:47
 * @Version 1.0
 */
public class BizException extends BaseException {


    public BizException(IErrorEnum responseEnum, Object[] args, String message) {
        super(responseEnum, args, message);
    }

    public BizException(IErrorEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(responseEnum, args, message, cause);
    }
}