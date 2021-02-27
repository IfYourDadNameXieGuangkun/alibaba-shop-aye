package com.lppz.stock.platform.base;

import com.lppz.takeout.exception.BizException;


public abstract class CallMethod<Req extends BaseRequest, Rsp extends BaseResponse> {
    public abstract CallPlatform<Rsp> buildCallParams(Req request);

    protected PlatformResult<Rsp> doCall(Req request) throws BizException {
        CallPlatform<Rsp> callPlatform = buildCallParams(request);
        PlatformResult<Rsp> result = callPlatform.call();
        return result;
    }
}
