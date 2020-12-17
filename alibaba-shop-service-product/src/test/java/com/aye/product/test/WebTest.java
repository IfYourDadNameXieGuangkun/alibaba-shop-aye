package com.aye.product.test;

import com.aye.commons.domain.DataProduct;
import com.aye.commons.domain.Product;
import com.aye.commons.utils.BeanUtils;
import com.aye.product.ProductServiceApplication;
import com.aye.product.config.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.net.URL;

/**
 * @ClassName WebTest
 * @Description Web层测试
 * @Author Aye
 * @Date 2020/8/29 17:24
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ProductServiceApplication.class, WebTest.class})
@AutoConfigureMockMvc
public class WebTest {

//    @LocalServerPort
//    private int port;
//
//    private URL base;
//
//    @Autowired
//    private TestRestTemplate template;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private Person person;

    @Before
    public void setup() throws Exception {
        //base = new URL("http://localhost:" + port + "/");
        // 实例化方式一
//        mockMvc = MockMvcBuilders.standaloneSetup(new Provider2FeignController()).build();
        // 实例化方式二
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


//    @Test
//    public void getHello()  {
//        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
//        assert (response.getBody().equals("Greetings from Spring Boot!"));
//    }


    @Test
    public void 根据sku查询商品() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get("/product/ZH110110B")
                .accept(MediaType.APPLICATION_JSON)) //执行请求
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)) //验证响应contentType
                .andDo(MockMvcResultHandlers.print());
        System.out.println(resultActions);
    }

    @Test
    public void 查询所有商品() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/product/list/products/")
                .accept(MediaType.APPLICATION_JSON)) //执行请求
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)) //验证响应contentType
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void 新增商品() throws Exception {
        Product product = Product.builder()
                .sku("ZH110110C")
                .productName("测试商品C")
                .price(BigDecimal.TEN)
                .build();
        System.out.println(BeanUtils.asJsonString(product));
        mockMvc.perform(MockMvcRequestBuilders
                .post("/product/")
                .content(BeanUtils.asJsonString(product))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)) //验证响应contentType
                .andDo(MockMvcResultHandlers.print());

    }


    @Test
    public void 查询所有订单() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/product/list/orders/")
                .accept(MediaType.APPLICATION_JSON)) //执行请求
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)) //验证响应contentType
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void 测试配置文件映射(){
        System.out.println(person);

    }


    @Test
    public void test() throws Exception {

        /*
         * 1、mockMvc.perform执行一个请求。
         * 2、MockMvcRequestBuilders.get("XXX")构造一个请求。
         * 3、ResultActions.param添加请求传值
         * 4、ResultActions.accept(MediaType.TEXT_HTML_VALUE))设置返回类型
         * 5、ResultActions.andExpect添加执行完成后的断言。
         * 6、ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情
         *   比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
         * 7、ResultActions.andReturn表示执行完成后返回相应的结果。
         */
//        String requestBody = "{\"userId\":131,\"userName\":\"bbbbw\",\"password\":\"12345\"," +
//                "\"phone\":\"13135699044\",\"payType\":2}";

        String requestBody = "{\"userId\":131,\"userName\":\"bbbbw\",\"password\":\"12345\"," +
                "\"phone\":\"13135699044\"}";

        mockMvc.perform(MockMvcRequestBuilders
                .post("/user/save")
                .contentType(MediaType.APPLICATION_JSON).content(requestBody)
                .accept(MediaType.APPLICATION_JSON)) //执行请求
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)) //验证响应contentType
                //.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(0)) //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/
                .andDo(MockMvcResultHandlers.print());

    }

}