package com.aye.product.test;

import com.aye.commons.domain.User;
import com.aye.commons.ex.exception.BaseException;
import com.aye.commons.ex.exception.BizException;
import com.aye.product.ProductServiceApplication;
import com.aye.product.constant.ResponseEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

/**
 * @ClassName optionalTets
 * @Description Optional 判空
 * @Author Aye
 * @Date 2020/9/8 11:40
 * @Version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ProductServiceApplication.class, WebTest.class})
public class optionalTest {

    /**
     * // 1、创建一个包装对象值为空的Optional对象
     * Optional<String> optEmpty = Optional.empty();
     * // 2、创建包装对象值非空的Optional对象
     * Optional<String> optOf = Optional.of("optional");
     * // 3、创建包装对象值允许为空也可以不为空的Optional对象
     * Optional<String> optOfNullable1 = Optional.ofNullable(null);
     * Optional<String> optOfNullable2 = Optional.ofNullable("optional");
     */

    @Test
    public void test01() {
//        User user = new User();
//        user.setUserName("aye");
//        user.setAge(10);
//        user.setPassword("123456");// throw new NullPointerException();
        User user = User.builder().userName("aye").age(10).password("123456").build();
        Optional<User> userOptional = Optional.ofNullable(user);
        String s = userOptional.map(User::getUserName)
                .map(String::toUpperCase)
                .orElse(null);

    }

    @Test
    public void test02_of() {
        Optional<String> aNull = Optional.ofNullable("null");
        if (aNull.isPresent()){
            System.out.println("123");
        }
    }

}