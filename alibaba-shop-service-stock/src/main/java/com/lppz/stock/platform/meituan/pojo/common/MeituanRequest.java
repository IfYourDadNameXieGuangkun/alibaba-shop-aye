package com.lppz.stock.platform.meituan.pojo.common;

import com.lppz.stock.platform.base.BaseRequest;
import com.lppz.stock.platform.base.IgnoreSign;
import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 美团的公共参数
 */
@Data
public abstract class MeituanRequest implements BaseRequest {
    @IgnoreSign
    private static final long serialVersionUID = 3569085533858588449L;
    protected String app_id;
    protected String timestamp;// 时间戳
    @IgnoreSign
    protected String sig;
    @JsonIgnore
    public abstract String getMethodUrl();
}
