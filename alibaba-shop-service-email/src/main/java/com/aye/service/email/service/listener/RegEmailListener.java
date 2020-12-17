package com.aye.service.email.service.listener;

import com.alibaba.fastjson.JSONObject;
import com.aye.commons.domain.User;
import com.aye.commons.stream.StreamSink;
import com.aye.service.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class RegEmailListener {

    @Autowired
    private EmailService emailService;

    @StreamListener(StreamSink.REG_INPUT)
    public void receiveRegMsg(String user){
        User user1 = JSONObject.parseObject(user, User.class);
        emailService.sendSimpleMail("m15677360304@163.com","会员注册成功","恭喜成为SpringCloudStream大神");
        System.out.println("123123"+user1.getUserName());
    }
}
