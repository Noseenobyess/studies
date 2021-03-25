package com.studies.mall.controller.redis;

import com.studies.mall.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "RedisController",description = "Redis测试")
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @ApiOperation("添加缓存")
    @GetMapping("/add")
    public void add(@RequestParam("key") String key,@RequestParam("value") String value){
        redisService.set(key,value);
    }

    @ApiOperation(value = "查询缓存")
    @GetMapping("/query")
    public String query(@RequestParam("key") String key){
        Object s = redisService.get(key);
        return String.valueOf(s);
    }
}
