package com.lppz.stock.platform.base;

import com.aye.commons.ex.exception.BizException;



public interface SynProvider {
    BaseResponse run(Object obj) throws BizException;
}
