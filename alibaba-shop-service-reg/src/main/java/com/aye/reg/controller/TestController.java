package com.aye.reg.controller;

import com.aye.commons.domain.User;
import com.aye.commons.dto.CR;
import com.aye.commons.dto.ResultDTO;
import com.aye.commons.stream.StreamSource;
import com.aye.reg.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("test")
@Api(tags = "测试control")
public class TestController {

    //    @Autowired
//    private ITUserService userService;
    @Autowired
    private IUserService userService;
    @Autowired
    private StreamSource source;

    @ApiOperation(value = "查询用户", notes = "名称查找")
    @GetMapping(value = "user/{name}")
    public String getUserByName(@ApiParam(name = "name", value = "用户名称") @PathVariable String name) {
        List<User> list = userService.list();
        list.forEach(user ->
                System.out.println(user.toString())
        );
        return "My Name is:" + list.size() + name;
    }


    @ApiOperation(value = "发送邮件测试", notes = "参数为发送信息")
    @PostMapping(value = "/sendEmail")
    public CR<?> userReg(@ApiParam(name = "msg", value = "用户模型") String msg) {

        source.REG_OUTPUT().send(MessageBuilder.withPayload(msg).build());
        return ResultDTO.create();
    }

    @ApiOperation(value = "创建用户测试", notes = "参数为发送信息")
    @PostMapping(value = "/random/create/user")
    public CR<?> createUser() {
//        User user = User.builder()
//                .userName("随机")
//                .password("123")
//                .age(18)
//                .married(1)
//                .email("suiji@163.com")
//                .tel("1313")
//                .card("123")
//                .salary(BigDecimal.ONE).build();
        User user = new User();
        user.setUserName("测试字段填充");
        boolean flag = userService.save(user);
        System.out.println(flag);
        return ResultDTO.create();
    }


}
