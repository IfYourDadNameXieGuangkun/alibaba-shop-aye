package com.aye.commons.ex.exception;

import com.aye.commons.ex.enums.IErrorEnum;

/**
 * @ClassName ValidationException
 * @Description
 *  * <p>校验异常</p>
 *  * <p>调用接口时，参数格式不合法可以抛出该异常</p>
 * @Author Aye
 * @Date 2020/9/1 16:29
 * @Version 1.0
 */
public class ValidationException extends BaseException  {
    public ValidationException(IErrorEnum errorEnum, Object[] args, String message) {
        super(errorEnum, args, message);
    }

    public ValidationException(IErrorEnum errorEnum, Object[] args, String message, Throwable cause) {
        super(errorEnum, args, message, cause);
    }
}