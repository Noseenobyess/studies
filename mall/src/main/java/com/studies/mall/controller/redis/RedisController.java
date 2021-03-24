package com.studies.mall.controller.redis;

import com.studies.mall.service.RedisService;
import io.swagger.annotations.Api;
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

    @GetMapping("/add")
    public void add(@RequestParam("key") String key,@RequestParam("value") String value){
        redisService.set(key,value);
    }

    @GetMapping("/query")
    public String query(@RequestParam("key") String key){
        Object s = redisService.get(key);
        return String.valueOf(s);
    }
}
