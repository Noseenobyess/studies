package com.studies.mall.controller;

import com.studies.mall.entity.UserDTO;
import com.studies.mall.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "UserController",description = "用户管理")
@RestController
@RequestMapping(value = "/user")
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
    public @ResponseBody List<UserDTO> queryUserList(@RequestBody UserDTO user){
        return userService.queryUserList();
    }
}
