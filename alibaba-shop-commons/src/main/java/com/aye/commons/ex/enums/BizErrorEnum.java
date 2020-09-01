package com.aye.commons.ex.enums;


/**
 * @ClassName BizErrorEnum
 * @Description [业务异常]自定义业务异常错误码,主要处理业务异常错误
 * @Author Aye
 * @Date 2020/9/1 11:36
 * @Version 1.0
 */
public enum  BizErrorEnum implements IErrorEnum {

    /**
     * 业务异常错误码,可以增量自定义
     */
    PRODUCT_CODE_SUCCESS(1000, "成功"),
    PRODUCT_CODE_NONE_ERROR(1001, "商品不存在"),
    PRODUCT_CODE_ERROR(1001, "商品异常"),

    ;

    BizErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;


    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}



//@Getter
//@AllArgsConstructor
//public enum  BizErrorEnum {
//
//    /**
//     * 业务异常错误码
//     */
//    PLATFORM_CODE_SUCCESS(1000, "成功"),
//    PLATFORM_CODE_ERROR(1001, "平台码错误"),
//    PLATFORM_CARRIER_CODE_ERROR(1002, "平台承运商编码错误"),
//    PLATFORM_CODE_NOT_EMPTY(1003, "平台编码不能为空"),
//    PLATFORM_CARRIER_CODE_NOT_EMPTY(1004, "平台承运商编码不能为空"),
//    PLATFORM_RESPONSE_ERROR(1005, "平台响应错误"),
//    PLATFORM_RESPONSE_FAIL(1006, "平台响应失败"),
//    PERFORM_SERVICE_RESPONSE_FAIL(1007, "履约服务内部错误"),
//
//    ;
//
////    BizErrorEnum(int code, String message) {
////        this.code = code;
////        this.message = message;
////    }
//
//    /**
//     * 返回码
//     */
//    private int code;
//    /**
//     * 返回消息
//     */
//    private String message;
//
//
//}