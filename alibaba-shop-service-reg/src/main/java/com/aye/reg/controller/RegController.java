package com.aye.reg.controller;

import com.aye.commons.service.ITUserService;
import com.aye.commons.domain.user.TUser;
import com.aye.commons.stream.StreamSource;
import com.aye.commons.validator.BeanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("reg")
public class RegController {
    @Value("${redis}")
    private String redis;

    @Autowired
    private ITUserService userService;
    @Autowired
    private StreamSource source;

    @GetMapping(value = "/user/{name}")
    public String getUserByName(@PathVariable String name) {
        List<TUser> list = userService.list();
        list.forEach(user ->
                System.out.println(user.toString())
        );
        return "My Name is:" + list.size() + name;
    }

    @PostMapping(value = "/user/")
    public String userReg(@RequestBody TUser user) {
        String message = BeanValidator.validator(user);
        if (!Optional.ofNullable(message).isPresent()){
            //todo 异步mq邮件发送注册成功
            source.EMAIL_OUTPUT().send(MessageBuilder.withPayload(user).build());
        }
        return message;
    }

}
