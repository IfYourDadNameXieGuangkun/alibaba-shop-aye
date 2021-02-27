package com.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {com.lppz.stock.StockApplication.class, ApiTest.class})
@Slf4j
public class ApiTest {

    private MockMvc mockMvc;
    private static final ObjectMapper objectMapper = new ObjectMapper();

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
    public void test01() throws Exception {
        com.lppz.stock.pojo.StockEntry stockEntry = new com.lppz.stock.pojo.StockEntry();
        stockEntry.setSku("ZH123");
        stockEntry.setStock(100);
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/stock/meituan")
//                .content(objectMapper.writeValueAsString(stockEntry))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print());
        System.out.println(resultActions);
    }
}
