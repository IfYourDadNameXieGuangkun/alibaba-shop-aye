package com.aye.reg.test;


import com.aye.commons.domain.User;
import com.aye.reg.RegServiceApplication;
import com.aye.reg.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RegServiceApplication.class,ApiTest.class})
@Slf4j
public class ApiTest {

    @Autowired
    private IUserService userService;

    @Test
    @After
    public void after(){

    }

    @Test
    public void testFeign01(){
        List<User> list = userService.list();
        list.forEach(user-> log.error(user.toString()));
    }

}
