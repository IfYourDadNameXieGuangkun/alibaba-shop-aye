package com.aye.commons.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @ClassName BeanUtils
 * @Description 工具类
 * @Author Aye
 * @Date 2020/9/4 13:49
 * @Version 1.0
 */
public class BeanUtils {

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}