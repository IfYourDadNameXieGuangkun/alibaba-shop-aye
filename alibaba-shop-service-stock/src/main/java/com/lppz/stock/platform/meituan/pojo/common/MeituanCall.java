package com.lppz.stock.platform.meituan.pojo.common;

import com.lppz.stock.platform.base.BaseResponse;
import com.lppz.stock.platform.base.CallPlatform;
import com.lppz.stock.platform.base.JacksonUtil;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @param <T>
 */
public abstract class MeituanCall<T extends BaseResponse> extends CallPlatform<T> {
    private MeituanRequest request;
    public MeituanCall(MeituanRequest request) {
        this.request = request;
    }
    public MeituanRequest getRequest() {
        return request;
    }
    @Override
    public CallType getCallType() {
        return CallType.GET;
    }

    @Override
    public Map<String, Object> buildHeader() {
        return null;
    }

    @Override
    public Object buildBody() {
        Map<String, String> params = new HashMap<String, String>();
        Map<String, Object> temp = new HashMap<String, Object>(MeituanUtil.buildCallBodyUrl(this.request));
        for (String key : temp.keySet()) {
            if(temp.get(key) instanceof Map){
                params.put(key, JacksonUtil.toJsonString(temp.get(key)).replace("\\\\", ""));
            }else{
                params.put(key, temp.get(key).toString());
            }
        }
        System.out.println("MeituanCall-buildBody["+params+"]");
        return params;
    }

    @Override
    public String buildUrl() {
        try {
            StringBuilder reUrl = new StringBuilder();
            long timestamp = System.currentTimeMillis();
            this.request.setTimestamp(String.valueOf(timestamp).substring(0, String.valueOf(timestamp).length()-3));
            StringBuilder callUrl = new StringBuilder( "MeituanConfig.url" + request.getMethodUrl());
            StringBuilder sbUrl = new StringBuilder(MeituanUtil.buildCallUrl(this.request, "MeituanConfig.url" + request.getMethodUrl()));
            String sign = DigestUtils.md5Hex(URLDecoder.decode(sbUrl.toString(), "UTF-8") + "MeituanConfig.consumer_secret");

//			callUrl.append("?app_id=").append(MeituanConfig.app_id);
//			callUrl.append("&timestamp=").append(timestamp);
            callUrl.append("?sig=").append(sign);
            sbUrl.append("&sig=").append(sign);
            if (getCallType() == CallType.POST) {
                reUrl = callUrl;
            } else if (getCallType() == CallType.GET) {
                reUrl = sbUrl;
            }
            //logger.info("meituan-buildUrl[{}]",reUrl.toString());
            System.out.println("meituan-buildUrl"+reUrl.toString());
            return reUrl.toString();
        } catch (UnsupportedEncodingException e) {
//            logger.error("build url error", e);
        }
        return null;
//		return MeituanConfig.url + this.request.getMethodUrl();
    }
}
