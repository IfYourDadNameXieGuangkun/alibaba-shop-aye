package com.lppz.stock.platform.base;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JacksonUtil {
	private static Logger logger = LoggerFactory.getLogger(JacksonUtil.class);
	public static String toJsonString(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.setSerializationInclusion(Inclusion.NON_NULL);
		try {
			return mapper.writeValueAsString(obj);
		} catch (IOException e) {
			logger.error("Object to String error", e);
			return null;
		}
	}
	
	
	public static final <T> T parseObject(String input, Class<T> clazz) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (StringUtils.isBlank(input)) {
				return null;
			}
			mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			T t = mapper.readValue(input, clazz);
			return t;
		} catch (Exception e) {
//			e.printStackTrace();
			logger.error("jackson parse to bean error,["+input+"]", e);
			return null;
		}
	}
	
	public static final <T> T parseObject(String input, TypeReference<T> type) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (StringUtils.isBlank(input)) {
				return null;
			}
			mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(input, type);
		} catch (Exception e) {
//			e.printStackTrace();
			logger.error("jackson parse to bean error,["+input+"]", e);
			return null;
		}
	}


	
	
}
