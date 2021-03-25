package com.studies.mall.controller.hibernate;

import com.google.gson.JsonObject;
import com.studies.mall.common.dto.CommonResult;
import com.studies.mall.entity.hibernate.ParamDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@Api(value = "hibernate",description = "hibernate测试",tags = "hibernate")
@RestController
@RequestMapping(value = "/hibernate")
@Slf4j
public class HibernateController {

    @ApiOperation(value = "验证单个参数")
    @GetMapping(value = "/valid")
    public CommonResult valid(@Min(value = 10, message = "id最小只能是10") @RequestParam("id")
                                          Integer id) {
        log.info("前端入参：{}",id);
        return CommonResult.success(null,"恭喜你,拿到数据了");
    }

    @ApiOperation(value = "验证参数绑定")
    @PostMapping(value = "/validDTO")
    public CommonResult validDTO(@Validated @RequestBody ParamDTO paramDTO, BindingResult result){
        log.info("前端入参：{}",paramDTO.toString());
        if(result.hasErrors()){
            StringBuffer sb = new StringBuffer();
            for (ObjectError error:result.getAllErrors()){
                log.error(error.getDefaultMessage());
                sb.append(error.getDefaultMessage()).append(";");
            }
           return CommonResult.validateFailed(sb.toString());
        }
        return CommonResult.success(null,"验证不通过");
    }
}
