package com.studies.mall.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import com.studies.mall.entity.UserDTO;
import com.studies.mall.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "UserController",description = "用户管理")
@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("查询用户")
    @GetMapping(value = "/query/{id}")
    public @ResponseBody UserDTO queryUser(@PathVariable(value = "id") Integer id){
        return userService.queryUserByWorknumber(id);
    }

    @ApiOperation("查询用户列表")
    @PostMapping(value = "/queryUserList")
    public @ResponseBody List<UserDTO> queryUserList(@Validated @RequestBody UserDTO user){
        log.info("入参",user);
        return userService.queryUserList();
    }
}
