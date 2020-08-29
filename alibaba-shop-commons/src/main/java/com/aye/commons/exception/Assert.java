package com.aye.commons.exception;


import java.util.Collection;


public interface Assert {

    /**
     * 创建异常
     * @param args args
     * @return BizException
     */
    BizException newException(Object... args);

    /**
     * 创建异常
     * @param t t
     * @param args args
     * @return BizException
     */
    BizException newException(Throwable t, Object... args);


    /**
     * 断言对象 obj 非空。如果对象 obj 为空，则抛出异常
     * @param obj 待判断对象
     */
    default void assertNotNull(Object obj) {
        assertNotNull(obj, "");
    }

    /**
     * 断言对象 obj 非空。如果对象 obj 为空，则抛出异常
     * 异常信息 message 支持传递参数方式，避免在判断之前进行字符串拼接操作
     * @param obj 待判断对象
     * @param args message占位符对应的参数列表
     */
    default void assertNotNull(Object obj, Object... args) {
        if (obj == null) {
            throw newException(args);
        }
    }


    /**
     * 断言字符串非空且非空字符串且非 " "
     * @param str str
     */
    default void notBlank(String str){
        assertNotNull(str, "");
        notBlank(str, "");
    }

    /**
     * 断言字符串非空且非空字符串且非 " "
     * @param str str
     * @param args args
     */
    default void notBlank(String str, Object... args){
        assertNotNull(str, args);
        str = str.replace(" ", "").trim();
        if(str.length() == 0){
            throw newException(str, args);
        }
    }

    /**
     * 断言集合不能为空，或者 size == 0； 如果集合为空或者 == 0, 则抛出异常
     * 异常信息 message, 支持参数传递，避免在判空之前进行字符串拼接操作
     * @param collection collection
     * @param args args
     */
    default void notEmpty(Collection<?> collection, Object... args){
        if(collection == null || collection.isEmpty()){
            throw newException(args);
        }
    }

    /**
     * 断言对象为为空，如果不为空则抛出异常
     * @param object object
     * @param args args
     */
    default void isNull(Object object, Object... args){
        if (object != null) {
            throw newException(object, args);
        }
    }

    /**
     * 断言对象必须为 true，如果不为 true 则抛出异常
     * @param expression expression
     * @param args args
     */
    default void isTrue(boolean expression, Object... args){
        if(!expression){
            throw newException(args);
        }
    }

    /**
     * 断言 content 是否以 prefix 开头
     * @param content content
     * @param prefix prefix
     * @param args args
     */
    default void startWith(String content, String prefix, Object... args){
        notBlank(content, args);
        notBlank(prefix, args);
        if(!content.startsWith(prefix)){
            throw newException(content, args);
        }
    }

}
