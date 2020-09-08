package com.aye.product.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Person
 * @Description 配置文件映射对象
 * @Author Aye
 * @Date 2020/9/8 14:36
 * @Version 1.0
 */

/**

         # 配置person属性值
         person:
         last-name: Darcy
         age: 20
         birth: 2018/01/01
         email: gmail@gmail.com
         maps:
            key1: java
            key2: golang
         lists:
         - a
         - b
         - c
         dog:
            name: 旺财
            age: 2
 */
@Data
@Component
//@PropertySource(value = "classpath:domain-person.properties")
@ConfigurationProperties(prefix = "person")
@Validated
public class Person {
    private String lastName;
    private Integer age;
    private Date birth;
    private Map<String, String> maps;
    private List<String> lists;
    private Dog dog;
    /**
     * 支持数据校验
     */
    @Email
    private String email;

}