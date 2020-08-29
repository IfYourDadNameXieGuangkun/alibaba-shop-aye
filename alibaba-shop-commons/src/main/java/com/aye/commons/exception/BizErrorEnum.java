package com.aye.commons.exception;


public enum BizErrorEnum implements BizExceptionAssert {

    SUCCESS_CODE(0, "success"),


    /**
     * 业务异常错误码
     */

    PLATFORM_CODE_ERROR(90, "平台码错误"),
    PLATFORM_CARRIER_CODE_ERROR(91, "平台承运商编码错误"),
    PLATFORM_CODE_NOT_EMPTY(92, "平台编码不能为空"),
    PLATFORM_CARRIER_CODE_NOT_EMPTY(93, "平台承运商编码不能为空"),

    PLATFORM_RESPONSE_ERROR(99, "平台响应错误"),
    PLATFORM_RESPONSE_FAIL(100, "平台响应失败"),
    PERFORM_SERVICE_RESPONSE_FAIL(101, "履约服务内部错误"),



    STORE_NOT_BIND_CARRIER(105, "门店未绑定有效的承运商"),
    UNSATISFIED_DISTRIBUTION_DISTANCE(106, "无满足配送区域的承运商"),
    STORE_BUSINESS_TIME_ERROR(108, "门店营业时间错误或无营业时间"),
    PERFORMANCE_ERROR(107, "履约失败，建议检查订单地址"),
    CALC_WALK_DISTANCE_ERROR(109, "履约失败（计算步行距离异常，请核实经纬度）"),
    CALL_REPEAT(110, "已成功呼叫履约，请不要重复调用"),
    ALL_PLATFORM_FAILED(111, "所有平台的承运商均无法满足履约条件"),

    INTERCEPT_ORDER_NOT_EXISTS(112, "拦截订单不存在"),
    INTERCEPT_ORDER_NOT_ALLOW(113, "当前订单状态不允许拦截"),
    INTERCEPT_ORDER_PERFORM_FAIL(116, "订单物流拦截失败"),
    PERFORM_ORDER_HAS_CANCELED(114, "当前订单已取消，无法进行再次履约"),
    ALL_PLATFORM_PERFORM_FAILED(115, "所有平台均履约失败"),
    SPECIAL_SOURCE_NOT_MATCH_MAPPINGS(117, "特殊渠道的订单未匹配上承运商"),
    ALL_PLATFORM_MISMATCH(118, "全平台承运商无法匹配该订单"),
    PLATFORM_CHANGED(119, "承运商超出响应时间,将进行切换承运商"),
    PERFORM_TYPE_DISTRIBUTION_MODE_MISMATCH(120, "配送类型和配送模式与订单不匹配"),
    NO_PERFORM_TYPE(121, "该订单无配送方式"),

    PLATFORM_ORDER_NOT_EXISTS(150, "履约订单不存在"),
    PLATFORM_ZJS_CALLBACK_NULL(151, "宅急送回调内容为空"),
    PLATFORM_DADA_INTERCEPT_FAIL(152, "目前订单中台不允许拦截"),


    CARRIER_NOT_ACTIVE(701, "承运商未激活"),
    CARRIER_CODE_EXISTS(702, "承运商编码已经存在"),
    CARRIER_NOT_FOUND(703, "承运商未找到"),
    CARRIER_NOT_SUPPORT(704, "不支持的承运商"),

    CATEGORY_NOT_ACTIVE(801, "履约类别未激活"),
    CATEGORY_CODE_EXISTS(802, "履约类别已经存在"),
    CATEGORY_NOT_FOUND(803, "履约类别未找到"),

    WAREHOUSE_NOT_FOUND(901, "京东仓库未配置"),






    /**
     * 平台配置文件相关异常
     */
    //dada 配置文件
    PLATFORM_PROPERTIES_INJECT_FAILED(755, "Platform properties file injection failed."),
    PLATFORM_DADA_ROOT_URL_NULL(756, "Platform[dada] root url not configured."),
    PLATFORM_DADA_CREATE_ORDER_URL_NULL(757, "Platform[dada] create order url not configured."),
    PLATFORM_DADA_CANCEL_ORDER_URL_NULL(758, "Platform[dada] cancel order url not configured."),
    PLATFORM_DADA_CALLBACK_NULL(759, "Platform callback url is not configured."),


    //顺丰配置文件
    PLATFORM_SF_ROOT_URL_NULL(760, "Platform[sf-express] root url not configured."),
    PLATFORM_SF_CREATE_ORDER_URL_NULL(761, "Platform[sf-express] create order url not configured."),
    PLATFORM_SF_CANCEL_ORDER_URL_NULL(762, "Platform[sf-express] create order url not configured."),

    DISTRIBUTION_MODE_NOT_SUPPORT(800, "配送模式不支持"),

    MOVE_POSITION_ERROR(1000,"已在最高/最低级别，无法移动"),
    STORE_NOT_CURRENT_CARRIER(1001,"门店绑定的当前承运商不存在"),
    MOVE_TOP_POSITION_ERROR(1002,"已经到顶，无法置顶"),
    MOVE_BOTTOM_POSITION_ERROR(1003,"已经到底，无法置底"),
    CARRIER_CATEGORY_MAPPING_ERROR(1004,"承运商映射已存在"),
    CARRIER_IN_CATEGORY_MAPPING_ERROR(1005,"当前已绑定映射关系，不允许停用"),
    ;





    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;

    BizErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}