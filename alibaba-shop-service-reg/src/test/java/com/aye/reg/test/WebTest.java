package com.aye.reg.test;

import com.aye.reg.RegServiceApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}