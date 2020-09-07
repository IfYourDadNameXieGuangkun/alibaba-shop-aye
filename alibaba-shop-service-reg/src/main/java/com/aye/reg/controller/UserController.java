package com.aye.reg.controller;

import com.aye.commons.domain.User;
import com.aye.commons.dto.CR;
import com.aye.commons.dto.ResultDTO;
import com.aye.reg.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "列表查询",notes = "无入参,查询所有用户信息",response = CR.class)
    @GetMapping("/")
    public CR<?> listUsers() {
        return ResultDTO.create(userService.list());
    }

    @ApiOperation(value = "新增用户", notes = "传入User对象", response = CR.class)
    @PostMapping("/")
    public CR<?> addUser(@Valid @RequestBody User user) {
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

}
