package com.lppz.stock.platform.base;

import com.aye.commons.ex.exception.BizException;
import com.lppz.util.http.BaseHttpClientsComponent;

import java.util.Map;

/**业务顶层封装代码,
 * @param <T>
 */
public abstract class CallPlatform<T extends BaseResponse> extends BaseHttpClientsComponent {
    public abstract Map<String, Object> buildHeader();

    public abstract Object buildBody();

    public abstract String buildUrl();

    public abstract PlatformResult<T> parseResult(String body);

    public CallType getCallType() {
        return CallType.POST;
    }

    public enum CallType {
        GET,
        POST,
        PUT,
        DELETE
    }
    public PlatformResult<T> call() throws BizException {
        String url = this.buildUrl();
        return parseResult("A:B");
    }

}
