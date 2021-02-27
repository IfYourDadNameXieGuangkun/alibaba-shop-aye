package com.lppz.stock.platform.meituan.pojo.common;

import com.google.common.collect.ImmutableMap;
import com.lppz.stock.platform.base.BaseRequest;
import com.lppz.stock.platform.base.IgnoreSign;

import com.lppz.stock.platform.base.JacksonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.*;


public class MeituanUtil {
	private static Logger logger = LoggerFactory.getLogger(MeituanUtil.class);
	
	private static Map<String, String> _configMap = new HashMap<String, String>();

	public static final String REPLACE_STRING = "@^#*^#@";
	// public static final String REPLACE_STRING_EQ = "@#^*#^@";
	//
	// public static final String SPLIT_STRING = "&";
	// public static final String SPLIT_STRING_EQ = "=";

	public static final Map<String, String> REPLACE_SPCIAL_GROUP = ImmutableMap.<String, String>builder()
			.put("&","@^#*^#@").put("=","@#^*#^@")
			.build();


    /**
     * 截取每一个 key-value 之间的值，将里面的 & 符号替换成特定的字符
     */
	public static final Map<String, String> REPLACE_FIELD = ImmutableMap.<String, String>builder()
			.put("detail","user_member_info").put("extras","incmp_modules").put("caution","original_price")
			.put("wm_poi_name","utime").put("wm_poi_address","wm_order_id_view")
			.put("recipient_name","order_id").put("recipient_address","sig").put("sku_benefit_detail","is_third_shipping")
			.build();

//	/**
//	 * 通过美团appid找到对应的店铺
//	 * @param appId
//	 * @return
//	 */
//	public static String queryChannelIdByAppId(String appId) {
//		String result = _configMap.get(appId);
//
//		if (StringUtils.isBlank(result)) {
//			Pattern pattern = Pattern.compile("^meituan.*.app_id");
//			Map<String, String> configMap = PropertyPlaceholderConfigurer.getCtxPropertiesMap();
//
//			for (Entry<String, String> entry : configMap.entrySet()) {
//				if (appId.equals(entry.getValue()) && pattern.matcher(entry.getKey()).matches()) {
//					String channelId = entry.getKey().substring(0, entry.getKey().lastIndexOf(".app_id"));
//					_configMap.put(appId, channelId);
//					result = channelId;
//				}
//			}
//		}
//		return result;
//	}
	
	@SuppressWarnings("unchecked")
	private static <T extends BaseRequest> List<Class<T>> getRequestClassGroup(Class<T> clazz) {
		List<Class<T>> result = new ArrayList<Class<T>>();
		result.add(clazz);
		if (clazz != MeituanRequest.class) {
			result.addAll(getRequestClassGroup((Class<T>)clazz.getSuperclass()));
		}
		return result;
	}
	
	/**
	 * 给bean里面的参数排序, 针对消息通知接口
	 * @param bean
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static <T extends BaseRequest> List<String> sortCallbackParams(T bean) {
		List classes = getRequestClassGroup(bean.getClass());
		List<Field> fields = new ArrayList<Field>();
		List<String> fieldNameList = new ArrayList<String>();
		
		for (Object clazz : classes) {
			fields.addAll(Arrays.asList(((Class)clazz).getDeclaredFields()));
		}
		
		for (Field field : fields) {
			if (field.getAnnotation(IgnoreSign.class) != null) {
				continue;
			}
			fieldNameList.add(field.getName());
		}
		
		Collections.sort(fieldNameList);
		return fieldNameList;
	}
	
	public static <T> T paramsToBean(String params, Class<T> clazz) throws Exception {
		T bean = clazz.newInstance();
		String[] fieldInfos = params.split("&");
		for (int i=0;i<fieldInfos.length;i++) {
			String fieldInfo=fieldInfos[i];
			int offset = fieldInfo.indexOf("=");
			if(offset!=-1){
				String fieldName = fieldInfo.substring(0, offset);
				String fieldValue = fieldInfo.substring(offset + 1);
				PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, bean.getClass());
				propertyDescriptor.getWriteMethod().invoke(bean, fieldValue);
			}else{
				if(fieldInfos[i-1].indexOf("=")!=-1&&fieldInfos[i-1].indexOf("=")!=0) {
					String fieldName = fieldInfos[i-1].substring(0, fieldInfos[i-1].indexOf("="));
					PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, bean.getClass());
					String fieldValue=propertyDescriptor.getReadMethod().invoke(bean).toString();
					propertyDescriptor.getWriteMethod().invoke(bean, fieldValue+="&"+fieldInfo);
				}
			}
		}
		return bean;
	}

//	/**
//	 * 将字符串解析成美团创建订单的实体
//	 *@autor:chengwenzhuo
//	 * @param param
//	 * @return
//	 */
//	public static CreateOrderRequest parseOrder(String param){
//		Map<String, String> map=new HashMap<String, String>();
//		String[] strArr=param.split("&");
//		for(String str:strArr){
//			String[]kvpair=str.split("=");
//			if(kvpair.length>1){
//				map.put(kvpair[0],kvpair[1]);
//			}else{
//				map.put(kvpair[0],"");
//			}
//
//		}
//		String total=map.get("total");
//		String delivery_time=map.get("delivery_time");
//		String utime=map.get("utime");
//		String wm_poi_name=map.get("wm_poi_name");
//		String detail=map.get("detail");
//		String caution=map.get("caution");
//		String original_price=map.get("original_price");
//		String order_id=map.get("order_id");
//		String recipient_name=map.get("recipient_name");
//		String wm_poi_phone=map.get("wm_poi_phone");
//		String city_id=map.get("city_id");
//		String timestamp=map.get("timestamp");
//		String pay_type=map.get("pay_type");
//		String wm_poi_id=map.get("wm_poi_id");
//		String longitude=map.get("longitude");
//		String avg_send_time=map.get("avg_send_time");
//		String day_seq=map.get("day_seq");
//		String status=map.get("status");
//		String invoice_title=map.get("invoice_title");
//		String app_poi_code=map.get("app_poi_code");
//		String shipper_phone=map.get("shipper_phone");
//		String is_third_shipping=map.get("is_third_shipping");
//		String shipping_fee=map.get("shipping_fee");
//		String ctime=map.get("ctime");
//		String has_invoiced=map.get("has_invoiced");
//		String extras=map.get("extras");
//		String recipient_phone=map.get("recipient_phone");
//		String wm_poi_address=map.get("wm_poi_address");
//		String wm_order_id_view=map.get("wm_order_id_view");
//		String app_id=map.get("app_id");
//		String latitude=map.get("latitude");
//		String recipient_address=map.get("recipient_address");
//		String sig=map.get("sig");
//		//增加美团配送方式字段
//		String logisticCode= map.get("logistics_code");
//		//增加美团良品会员信息字段
//        String userMemberInfo= map.get("user_member_info");
//		//增加订单数据状态标记,是否数据降级
//        String incmp_code = map.get("incmp_code");
//        //增加有降级的数据模块的集合
//        String incmp_modules  = map.get("incmp_modules");
//        //增加商品优惠详情
//        String sku_benefit_detail = map.get("sku_benefit_detail");
//
//        //包装订单
//		CreateOrderRequest entity=new CreateOrderRequest();
//		entity.setTotal(total);
//		entity.setDelivery_time(delivery_time);
//		entity.setUtime(utime);
//		entity.setWm_poi_name(wm_poi_name);
//		entity.setDetail(detail);
//		entity.setCaution(caution);
//		entity.setOriginal_price(original_price);
//		entity.setOrder_id(order_id);
//		entity.setRecipient_name(recipient_name);
//		entity.setWm_poi_phone(wm_poi_phone);
//		entity.setCity_id(city_id);
//		entity.setTimestamp(timestamp);
//		entity.setPay_type(pay_type);
//		entity.setWm_poi_id(wm_poi_id);
//		entity.setLongitude(longitude);
//		entity.setAvg_send_time(avg_send_time);
//		entity.setDay_seq(day_seq);
//		entity.setStatus(status);
//		entity.setInvoice_title(invoice_title);
//		entity.setApp_poi_code(app_poi_code);
//		entity.setShipper_phone(shipper_phone);
//		entity.setIs_third_shipping(is_third_shipping);
//		entity.setShipping_fee(shipping_fee);
//		entity.setCtime(ctime);
//		entity.setHas_invoiced(has_invoiced);
//		entity.setExtras(extras);
//		entity.setRecipient_phone(recipient_phone);
//		entity.setWm_poi_address(wm_poi_address);
//		entity.setWm_order_id_view(wm_order_id_view);
//		entity.setApp_id(app_id);
//		entity.setLatitude(latitude);
//		entity.setRecipient_address(recipient_address);
//		entity.setSig(sig);
//		entity.setLogistics_code(logisticCode);
//		entity.setUser_member_info(userMemberInfo);
//		entity.setIncmp_code(incmp_code);
//		if (StringUtils.isNotBlank(incmp_modules)){
//			List<String> list = Arrays.asList(incmp_modules.substring(1,incmp_modules.length()-1).split(","));
//			entity.setIncmp_modules(new HashSet<>(list));
//		}
//		if (StringUtils.isNotBlank(sku_benefit_detail)){
//			entity.setSku_benefit_detail(sku_benefit_detail);
//		}
//
//		return entity;
//	}
//
//	/**
//	 *
//	 * @param param
//	 * @return
//	 */
//	public static RefundRequest parseRefund(Map<String, String[]> param){
//
//		String timestamp=param.get("timestamp")[0];
//		String reason=param.get("reason")[0];
//		String is_appeal=param.get("is_appeal")[0];
//		String pictures=param.get("pictures")[0];
//		String notify_type=param.get("notify_type")[0];
//		String app_id=param.get("app_id")[0];
//		String order_id=param.get("order_id")[0];
//		String res_type=param.get("res_type")[0];
//		String sig=param.get("sig")[0];
//
//		//包装订单
//		RefundRequest refundRequest=new RefundRequest();
//		refundRequest.setApp_id(app_id);
//		refundRequest.setIs_appeal(is_appeal);
//		refundRequest.setNotify_type(notify_type);
//		refundRequest.setOrder_id(order_id);
//		refundRequest.setPictures(pictures);
//		refundRequest.setReason(reason);
//		refundRequest.setRes_type(res_type);
//		refundRequest.setTimestamp(timestamp);
//		refundRequest.setSig(sig);
//
//		return refundRequest;
//	}
//
//	/**
//	 * 根据美团传递的参数生成对应的签名
//	 * @autor  chengwenzhuo
//	 * @return
//	 */
//	public static String getSign(String param){
//		//将参数解析成map
//		Map<String, String> map=new HashMap<String, String>();
//		String[]strArr=param.split("&");
//		for(String str:strArr){
//			String[] kvpair=str.split("=");
//			//过滤sig
//			if("sig".equals(kvpair[0])){
//				continue;
//			}
//			if(kvpair.length>1){
//				map.put(kvpair[0],kvpair[1]);
//			}else{
//				map.put(kvpair[0],"");
//			}
//		}
//		//将所有参数（sig除外）按照参数名的字母顺序排序，并用&连接
//		Set<String> keySet=map.keySet();
//		List<String> paramNames=new ArrayList<String>(keySet);
//		Collections.sort(paramNames);
//		//按照请求url + ? + 排序后的参数 + consumer_secret的顺序进行连接，得到加密前的字符串:
//		StringBuffer sb=new StringBuffer();
//		sb.append(MeituanConfig.callback_url);
//		sb.append("?");
//		for(int i=0;i<paramNames.size();i++){
//			String paramName=paramNames.get(i);
//			String paramVal=map.get(paramName);
//			sb.append(paramName).append("=").append(paramVal);
//			if(i!=paramNames.size()-1){
//				sb.append("&");
//			}
//		}
//		sb.append(MeituanConfig.consumer_secret);
//		Set<String> resplaceSet = REPLACE_SPCIAL_GROUP.keySet();
//		String md5Str = sb.toString();
//		for (String key : resplaceSet) {
//			md5Str = md5Str.replace(REPLACE_SPCIAL_GROUP.get(key), key);
//		}
//		//System.out.println("md5Str:"+md5Str);
//		logger.info("美团签名加密前的字符串："+md5Str);
//		String sign= MD5Util.MD5(md5Str);
//		return sign;
//	}
//
//    public static String getSign(String param, String url, Map<String, String> requestMap){
//
//
//        Map<String, String> map = new HashMap<String, String>();
//
////        String[] strArr =param.split("\\?");
//
//        String[] strArr=param.split("&");
//
//        for(String str:strArr){
//            String[] kvpair=str.split("=");
//            //过滤sig
//            if("sig".equals(kvpair[0])){
//                requestMap.put(kvpair[0],kvpair[1]);
//                continue;
//            }
//            if(kvpair.length>1){
//                map.put(kvpair[0],kvpair[1]);
//                requestMap.put(kvpair[0],kvpair[1]);
//            }else{
//                map.put(kvpair[0],"");
//                requestMap.put(kvpair[0],"");
//            }
//        }
//        //将所有参数（sig除外）按照参数名的字母顺序排序，并用&连接
//        Set<String> keySet=map.keySet();
//        List<String> paramNames=new ArrayList<String>(keySet);
//        Collections.sort(paramNames);
//        //按照请求url + ? + 排序后的参数 + consumer_secret的顺序进行连接，得到加密前的字符串:
//        StringBuffer sb=new StringBuffer();
//        sb.append(url);
//        sb.append("?");
//        for(int i=0;i<paramNames.size();i++){
//            String paramName=paramNames.get(i);
//            String paramVal=map.get(paramName);
//            sb.append(paramName).append("=").append(paramVal);
//            if(i!=paramNames.size()-1){
//                sb.append("&");
//            }
//        }
//        sb.append(MeituanConfig.consumer_secret);
//		String md5Str = sb.toString();
//		Set<String> resplaceSet = REPLACE_SPCIAL_GROUP.keySet();
//		for (String key : resplaceSet) {
//			md5Str = md5Str.replace(REPLACE_SPCIAL_GROUP.get(key), key);
//		}
//        //System.out.println("md5Str:"+md5Str);
//        logger.info("美团签名加密前的字符串："+md5Str);
//        String sign= MD5Util.MD5(md5Str);
//        return sign;
//    }
//
//	public static String getSign(Map<String, String[]> param) throws UnsupportedEncodingException {
//
//		//将所有参数（sig除外）按照参数名的字母顺序排序，并用&连接
//		Set<String> keySet=param.keySet();
//		List<String> paramNames=new ArrayList<String>(keySet);
//		Collections.sort(paramNames);
//		//按照请求url + ? + 排序后的参数 + consumer_secret的顺序进行连接，得到加密前的字符串:
//		StringBuffer sb=new StringBuffer();
//		sb.append(MeituanConfig.refund_url);
//		sb.append("?");
//		for(int i=0;i<paramNames.size();i++){
//			String paramName=paramNames.get(i);
//			if("sig".equals(paramName)){
//				continue;
//			}
//			String paramVal=param.get(paramName)[0];
///*			if("reason".equals(paramName)){
//				paramVal = URLDecoder.decode(paramVal,"UTF-8");
//			}*/
//			sb.append(paramName).append("=").append(paramVal);
//			if(i!=paramNames.size()-1){
//				sb.append("&");
//			}
//		}
//		sb.append(MeituanConfig.consumer_secret);
//		String md5Str=sb.toString();
//		//System.out.println("md5Str:"+md5Str);
//		logger.info("美团签名加密前的字符串："+md5Str);
//		String sign= MD5Util.MD5(md5Str);
//		return sign;
//	}
//
//	public static String getSign(Map<String, String[]> param, String url) throws UnsupportedEncodingException {
//		//将所有参数（sig除外）按照参数名的字母顺序排序，并用&连接
//		Set<String> keySet=param.keySet();
//		List<String> paramNames=new ArrayList<String>(keySet);
//		Collections.sort(paramNames);
//		//按照请求url + ? + 排序后的参数 + consumer_secret的顺序进行连接，得到加密前的字符串:
//		StringBuffer sb=new StringBuffer();
//		sb.append(url);
//		sb.append("?");
//		for(int i=0;i<paramNames.size();i++){
//			String paramName=paramNames.get(i);
//			if("sig".equals(paramName)){
//				continue;
//			}
//			String paramVal=param.get(paramName)[0];
///*			if("reason".equals(paramName)){
//				paramVal = URLDecoder.decode(paramVal,"UTF-8");
//			}*/
//			sb.append(paramName).append("=").append(paramVal);
//			if(i!=paramNames.size()-1){
//				sb.append("&");
//			}
//		}
//		sb.append(MeituanConfig.consumer_secret);
//		String md5Str=sb.toString();
//		//System.out.println("md5Str:"+md5Str);
//		logger.info("美团签名加密前的字符串："+md5Str);
//		String sign= MD5Util.MD5(md5Str);
//		return sign;
//	}
//
	/**
	 * 构建SIGN的原始字符串
	 * @param bean
	 * @param url
	 * @return
	 */
	public static String buildCallUrl(MeituanRequest bean, String url) {
		List<String> fieldNames = sortCallbackParams(bean);
		StringBuilder result = new StringBuilder(url);

		boolean firstConnectSign = true;

		for (String fieldName : fieldNames) {
			try {
				PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, bean.getClass());
				Object filedValue = propertyDescriptor.getReadMethod().invoke(bean);

				if (firstConnectSign) {
					result.append("?");
					firstConnectSign = false;
				} else {
					result.append("&");
				}
				result.append(fieldName).append("=");
				if (filedValue != null) {
					filedValue = URLEncoder.encode(filedValue.toString(), "UTF-8");
					result.append(filedValue);
				}

			} catch (IllegalArgumentException | IllegalAccessException | SecurityException | IntrospectionException | InvocationTargetException | UnsupportedEncodingException e) {
				logger.error("read property value error", e);
			}
		}
		logger.debug("buildOriginalSign is [{}]", result);
		return result.toString();
	}
//
//	/**
//	 * 将推送的原始报文转为 map 用于验签
//	 * @param params  例如：app_id=277&reason_code=1103
//	 * @return
//	 */
//	public static Map<String, String> parseRequestToMap(String params){
//		Map<String, String> map = new TreeMap<>();
//		if (StringUtils.isNotBlank(params)){
//			String[] array = params.split("&");
//			if (array.length > 0){
//				for (int i = 0; i < array.length; i++) {
//					String[] param = array[i].split("=");
//					if (param.length >= 2){
//						map.put(param[0], param[1]);
//					}else {
//						map.put(param[0], null);
//					}
//
//				}
//			}
//		}
//		return map;
//	}
//
//	/**
//	 * 将请求参数拼接完整 url
//	 * @param map
//	 * @param url
//	 * @return
//	 */
//	public static String buildCallUrlByMap(Map<String, String> map, String url) {
//		StringBuilder result = new StringBuilder(url);
//		boolean firstConnectSign = true;
//		for (Map.Entry<String, String> entry : map.entrySet()) {
//			if (!"sig".equals(entry.getKey())){
//				if (firstConnectSign) {
//					result.append("?");
//					firstConnectSign = false;
//				} else {
//					result.append("&");
//				}
//				result.append(entry.getKey()).append("=");
//				Object filedValue = entry.getValue();
//				if (filedValue != null) {
//					try {
//						filedValue = URLEncoder.encode(filedValue.toString(), "UTF-8");
//					} catch (UnsupportedEncodingException e) {
//						e.printStackTrace();
//					}
//					result.append(filedValue);
//				}
//			}
//		}
//
//		return result.toString();
//	}
//
	public static Map<String, Object> buildCallBodyUrl(MeituanRequest bean) {
		List<String> fieldNames = sortCallbackParams(bean);
		Map<String, Object> map = new HashMap<String, Object>();
		for (String fieldName : fieldNames) {
			try {
				PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, bean.getClass());
				Object filedValue = propertyDescriptor.getReadMethod().invoke(bean);

				if(filedValue!=null&&!filedValue.equals("null")){
					if(filedValue instanceof Map){
						map.put(fieldName, JacksonUtil.toJsonString(filedValue).replace("\\\\", ""));
					}else{
						map.put(fieldName, filedValue);
					}
				}
			} catch (IllegalArgumentException | IllegalAccessException | SecurityException | IntrospectionException | InvocationTargetException e) {
				logger.error("read property value error", e);
			}
		}
		logger.debug("buildCallBodyUrl is [{}]", map);
		return map;
	}
//
//	public static void main(String[] args) {
//		String param="total=34.3&delivery_time=0&utime=1529718511&wm_poi_name=良品铺子（长沙中南汽车城店）&detail=[{\"app_food_code\":\"ZH11105031\",\"box_num\":0,\"box_price\":0,\"food_discount\":1,\"food_name\":\"菲律宾芒果干48g/袋\",\"price\":11.9,\"quantity\":1,\"sku_id\":\"ZH11105031\",\"unit\":\"份\"},{\"app_food_code\":\"ZH11107080\",\"box_num\":0,\"box_price\":0,\"food_discount\":1,\"food_name\":\"猪肉脯散称3小包/份 55-65g\",\"price\":10.8,\"quantity\":1,\"sku_id\":\"ZH11107080\",\"unit\":\"份\"},{\"app_food_code\":\"ZH11105083\",\"box_num\":0,\"box_price\":0,\"food_discount\":1,\"food_name\":\"脆冬枣35g/袋\",\"price\":7.5,\"quantity\":1,\"sku_id\":\"ZH11105083\",\"unit\":\"份\"}]&caution= 【如遇缺货】： 缺货时电话与我沟通&original_price=34.3&order_id=738257204740096&recipient_name=何(女士)&wm_poi_phone=18890364546&city_id=430100&timestamp=1529718526&pay_type=2&wm_poi_id=1180435&longitude=113.067908&avg_send_time=1815.0&day_seq=1&status=2&invoice_title=&app_poi_code=5757&shipper_phone=&is_third_shipping=0&shipping_fee=4.1&ctime=1529718511&has_invoiced=0&extras=[{\"mt_charge\":0,\"poi_charge\":0,\"reduce_fee\":0,\"remark\":\"送8元商家代金券\",\"type\":100}]&recipient_phone=15084759290&wm_poi_address=湖南省长沙市长沙市长沙县中南汽车世界L01栋101-102号门面&wm_order_id_view=11804354048874258&app_id=277&latitude=28.233723&recipient_address=湖南广汽长坤汽车销售有限公司 (收银室)&sig=7b261f4b0840ec968689850f64fa447b";
////		CreateOrderRequest entity=MeituanUtil.parseOrder(param);
////		String json=JSON.toJSONString(entity);
////		System.out.println(json);
//		String sign=MeituanUtil.getSign(param);
//		String sig="7b261f4b0840ec968689850f64fa447b";
////		System.out.println("isTrue:"+sig.equals(sign));
////		System.out.println(sign);
//	}
//
//	public static String getRegexSign(String params, String url, Map<String, String> requestMap) {
//		Map<String, String> map = new HashMap<String, String>();
//
//		String caution_regex = "[\\s\\S]*(?<=caution=)([\\s\\S]*)(?=&original_price)[\\s\\S]*";
//		String recipient_name_regex = "[\\s\\S]*(?<=recipient_name=)([\\s\\S]*)(?=&order_id)[\\s\\S]*";
//		String recipient_address_regex = "[\\s\\S]*(?<=recipient_address=)([\\s\\S]*)(?=&sig)[\\s\\S]*";
//		String caution = params.replaceAll (caution_regex, "$1");
//		String recipient_name = params.replaceAll (recipient_name_regex, "$1");
//		String recipient_address = params.replaceAll (recipient_address_regex, "$1");
//		//String paramsRegex = params.replace(recipient_address,"####").replace(caution,"####").replace(recipient_name,"####");
//		if(org.apache.commons.lang3.StringUtils.isNotBlank(recipient_address)){
//			params = params.replace(recipient_address,"####");
//		}
//		if(org.apache.commons.lang3.StringUtils.isNotBlank(caution)){
//			params = params.replace(caution,"####");
//		}
//		if(org.apache.commons.lang3.StringUtils.isNotBlank(recipient_name)){
//			params = params.replace(recipient_name,"####");
//		}
//
//		String[] strArr=params.split("&");
//
//		for(String str:strArr){
//			String[] kvpair=str.split("=");
//			//过滤sig
//			if("sig".equals(kvpair[0])){
//				requestMap.put(kvpair[0],kvpair[1]);
//				continue;
//			}
//			if(kvpair.length>1){
//				map.put(kvpair[0],kvpair[1]);
//				requestMap.put(kvpair[0],kvpair[1]);
//			}else{
//				map.put(kvpair[0],"");
//				requestMap.put(kvpair[0],"");
//			}
//		}
//		logger.info("paramMap:{}",map);
//		map.put("caution",caution);
//		map.put("recipient_name",recipient_name);
//		map.put("recipient_address",recipient_address);
//		logger.info("paramMap:{}",map);
//		//将所有参数（sig除外）按照参数名的字母顺序排序，并用&连接
//		Set<String> keySet=map.keySet();
//		List<String> paramNames=new ArrayList<String>(keySet);
//		Collections.sort(paramNames);
//		//按照请求url + ? + 排序后的参数 + consumer_secret的顺序进行连接，得到加密前的字符串:
//		StringBuffer sb=new StringBuffer();
//		sb.append(url);
//		sb.append("?");
//		for(int i=0;i<paramNames.size();i++){
//			String paramName=paramNames.get(i);
//			String paramVal=map.get(paramName);
//			sb.append(paramName).append("=").append(paramVal);
//			if(i!=paramNames.size()-1){
//				sb.append("&");
//			}
//		}
//		sb.append(MeituanConfig.consumer_secret);
//		String md5Str=sb.toString();
//		logger.info("finish regex sign before MD5:"+md5Str);
//		String sign= MD5Util.MD5(md5Str);
//		return sign;
//	}
//
//	/**
//	 * 替换推送消息中某些字段值的&符号
//	 * @param originalStr 替换前字符串
//	 * @param resultMap	  返回消息map
//	 * @return
//	 */
//	public static Map<String, String> replaceSpecialStr(String originalStr, Map<String, String> resultMap) {
//		Set<String> keySet = REPLACE_FIELD.keySet();
//		String temParams = StringUtils.EMPTY;
//		for (String key : keySet) {
//
//			if (originalStr.contains(key)) {
//				temParams = doReplace(key, originalStr, temParams);
//			}
//		}
//
//		// 标记参数已被过滤
//		if (StringUtils.isNotBlank(temParams)) {
//			resultMap.put("replaceFlag", "1");
//			resultMap.put("newParams", temParams);
//		}
//		return resultMap;
//	}
//
//	/**
//	 * 替换特殊字符串逻辑
//	 * @param key	参数中对应的key
//	 * @param originalStr	原参数(过程中可能被替换)
//	 * @param temParams		临时存储参数变量
//	 * @return
//	 */
//	public static String doReplace(String key, String originalStr, String temParams) {
//
//		// 判断当前字符串是否已被替换
//		if (StringUtils.isNotBlank(temParams)) {
//			originalStr = temParams;
//		}
//
//		int headIdx = originalStr.indexOf(key);
//
//		int tailIdx = 0;
//		if ("recipient_name".equals(key)) {
//			// 有两个key包含order_id
//			tailIdx = originalStr.indexOf(REPLACE_FIELD.get(key));
//		} else {
//			String value = REPLACE_FIELD.get(key);
//			// 美团回调参数user_member_info非必传
//			if ("user_member_info".equals(value) && !originalStr.contains(value)) {
//				value = "caution";
//			}
//			tailIdx = originalStr.lastIndexOf(value);
//		}
//
//		// 得出目标字符串(key = value形式)和首尾字符串
//		String targetStr = originalStr.substring(headIdx, tailIdx - 1);
//		int targetLength = targetStr.length();
//		String headStr = originalStr.substring(0, headIdx);
//		String tailStr = originalStr.substring(headIdx + targetLength);
//
//		// 查询最近一个=符号, 去除value值中的=符号
//		int firstIdx = targetStr.indexOf("=");
//		String keyEqStr = targetStr.substring(0, firstIdx + 1);
//		String valueStr = targetStr.substring(firstIdx + 1);
//		Set<String> keySet = REPLACE_SPCIAL_GROUP.keySet();
//		for (String replaceKey : keySet) {
//			if (valueStr.contains(replaceKey)) {
//				valueStr = valueStr.replace(replaceKey, REPLACE_SPCIAL_GROUP.get(replaceKey));
//				String newParams = new StringBuffer().append(headStr).append(keyEqStr).append(valueStr).append(tailStr).toString();
//				temParams = newParams;
//			}
//		}
//
//		return temParams;
//	}
}
