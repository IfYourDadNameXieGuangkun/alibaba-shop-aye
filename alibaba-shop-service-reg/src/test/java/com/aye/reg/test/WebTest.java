package com.aye.reg.test;

import com.aye.commons.domain.DataProduct;
import com.aye.commons.domain.User;
import com.aye.commons.utils.BeanUtils;
import com.aye.reg.RegServiceApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;

/**
 * @ClassName WebTest
 * @Description TODO
 * @Author Aye
 * @Date 2020/8/29 17:24
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RegServiceApplication.class, WebTest.class})
public class WebTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        // 实例化方式一
//        mockMvc = MockMvcBuilders.standaloneSetup(new Provider2FeignController()).build();
        // 实例化方式二
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void 查询所有用户() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/user/list/")
                .accept(MediaType.APPLICATION_JSON)) //执行请求
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)) //验证响应contentType
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void 新增用户() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/user/list/")
                .accept(MediaType.APPLICATION_JSON)) //执行请求
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)) //验证响应contentType
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void 新增商品() throws Exception {
        User user = new User();
        user.setUserName("aye");
        user.setPassword("aye");
        user.setAddr("aye");
        user.setAge(18);
        user.setCard("123456789012345678");
        user.setEmail("2222@qq.com");
        user.setMarried(false);
        user.setSex(true);
        user.setSalary(1233.112F);
        user.setTel("1234567");
        System.out.println(BeanUtils.asJsonString(user));
        mockMvc.perform( MockMvcRequestBuilders
                .post("/user/save/")
                .content(BeanUtils.asJsonString(user))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)) //验证响应contentType
                .andDo(MockMvcResultHandlers.print());

    }


    @Test
    public void 通过用户名查询商品信息__服务reg调用服务product() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/user/list/products/aye")
                .accept(MediaType.APPLICATION_JSON)) //执行请求
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)) //验证响应contentType
                .andDo(MockMvcResultHandlers.print());

    }


}