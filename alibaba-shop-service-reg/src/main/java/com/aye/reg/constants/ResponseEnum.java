package com.aye.reg.constants;

import com.aye.commons.ex.assertion.BizExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseEnum implements BizExceptionAssert {

    PRODUCT_SKU_NOT_FOUND(8001, "用户不存在")

    ;

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;
}
