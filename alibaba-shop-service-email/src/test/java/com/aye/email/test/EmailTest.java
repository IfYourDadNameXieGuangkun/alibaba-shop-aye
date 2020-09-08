package com.aye.email.test;

import com.aye.service.email.EmailServiceApplication;
import com.aye.service.email.service.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thymeleaf.TemplateEngine;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName EmailTest
 * @Description 邮件测试类
 * @Author Aye
 * @Date 2020/9/8 16:26
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EmailServiceApplication.class)
public class EmailTest {
    @Autowired
    private EmailService mailService;
    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void sendSimpleTextMailTest() {
        String to = "baiwei@lppz.com";
        String subject = "Springboot 发送简单文本邮件";
        String content = "<p>第一封 Springboot 简单文本邮件</p>";
        mailService.sendSimpleMail(to, subject, content);
    }

    @Test
    public void sendHtmlMailTest() {
        String to = "baiwei@lppz.com";
        String subject = "Springboot 发送 HTML 邮件";
        String content = "<h2>Hi~</h2><p>第一封 Springboot HTML 邮件</p>";
        mailService.sendHtmlMail(to, subject, content);
    }

    @Test
    public void sendAttachmentsMailTest() throws Exception {
        String to = "baiwei@lppz.com";
        String subject = "Springboot 发送 HTML 附件邮件";
        String content = "<h2>Hi~</h2><p>第一封 Springboot HTML 附件邮件</p>";
        String filePath = "pom.xml";
        mailService.sendAttachmentMail(to, subject, content, filePath,filePath);
    }

    @Test
    public void sendImgTest() throws MessagingException {
        String to = "baiwei@lppz.com";
        String subject = "Springboot 发送 HTML 图片邮件";
        String content =
                "<h2>Hi~</h2><p>第一封 Springboot HTML 图片邮件</p><br/><img src='cid:img01' /><img src='cid:img02' />";
        String imgPath = "apple.png";
        Map<String, String> imgMap = new HashMap<>();
        imgMap.put("img01", imgPath);
        imgMap.put("img02", imgPath);
        mailService.sendImgMail(to, subject, content, imgMap);
    }

    @Test
    public void sendTemplateMailTest() throws MessagingException {
        String to = "baiwei@lppz.com";
        String subject = "Springboot 发送 模版邮件";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("username", "Darcy");
        mailService.sendTemplateMail(to, subject, paramMap, "RegisterSuccess");
    }
}