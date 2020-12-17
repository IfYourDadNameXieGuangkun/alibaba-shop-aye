package com.aye.reg.controller;

import com.aye.commons.domain.User;
import com.aye.commons.dto.CR;
import com.aye.commons.dto.ResultDTO;
import com.aye.commons.stream.StreamSource;
import com.aye.reg.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("user")
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private StreamSource source;

    @ApiOperation(value = "列表查询", notes = "无入参,查询所有用户信息", response = CR.class)
    @GetMapping("/")
    public CR<?> listUsers() {
        return ResultDTO.create(userService.list());
    }

    @ApiOperation(value = "新增用户", notes = "传入User对象,并发送邮件", response = CR.class)
    @PostMapping("/")
    public CR<?> addUser(@Valid @RequestBody User user) {
        if (Optional.ofNullable(user.getUserName()).isPresent() && user.getUserName().equals("admin")) {
            //todo 异步mq邮件发送注册成功
            source.REG_OUTPUT().send(MessageBuilder.withPayload(user).build());
        }
        return ResultDTO.create(userService.save(user));
    }

    @ApiOperation(value = "通过ID查询用户", notes = "传入id", response = CR.class)
    @PostMapping("/{id}")
    public CR<?> getUserById(@PathVariable("id") String id) {
        return ResultDTO.create(userService.getById(id));
    }

    @GetMapping("/products/{username}")
    public CR<?> listProductsByUserName(@PathVariable(name = "username") String username) {
        return ResultDTO.create(userService.listProductsByUserName(username));
    }

    @ApiOperation(value = "一键创建用户并发送邮件", notes = "无参", response = CR.class)
    @PostMapping("/random")
    public CR<?> addUser() {
        User user = User.builder()
                .userName("随机")
                .password("123")
                .age(18)
                .married(1)
                .email("suiji@163.com")
                .tel("1313")
                .addr("随机地址")
                .card("123")
                .salary(BigDecimal.ONE).build();

        source.REG_OUTPUT().send(MessageBuilder.withPayload(user).build());
        return ResultDTO.create("success");
    }

}
