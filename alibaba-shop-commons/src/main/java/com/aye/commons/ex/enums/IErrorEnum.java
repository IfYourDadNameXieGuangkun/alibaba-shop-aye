package com.aye.commons.ex.enums;

/**
 * @ClassName IExceptionEnum
 * @Description 该接口定义了异常信息返回的通用字段
 * @Author Aye
 * @Date 2020/9/1 11:06
 * @Version 1.0
 *
 *
 */
public interface IErrorEnum {
    /**
     * 返回错误代码
     * @return
     */
    int getCode();

    /**
     * 返回错误信息
     * @return
     */
    String getMessage();
}