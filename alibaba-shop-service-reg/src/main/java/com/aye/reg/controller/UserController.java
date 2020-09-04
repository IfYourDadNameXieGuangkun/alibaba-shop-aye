package com.aye.reg.controller;

import com.aye.commons.domain.User;
import com.aye.commons.dto.CR;
import com.aye.commons.dto.ResultDTO;
import com.aye.reg.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    public CR<?> listUser(){
        return ResultDTO.create(userService.list());
    }

    @PostMapping("/save")
    public CR<?> listUser(@Valid @RequestBody User user){
        return ResultDTO.create(userService.save(user));
    }

    @GetMapping("/list/products/{username}")
    public CR<?> listProductsByUserName(@PathVariable(name = "username")String username){
        return ResultDTO.create(userService.listProductsByUserName(username));
    }

}
