package com.studies.mall.common;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Validator;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Date;

@Slf4j
public class UtilsTest {
    public static void main(String[] args) {
        boolean chinese = Validator.isChinese("www");
        boolean email = Validator.isEmail("157347084@qq.com");
        boolean mobile = Validator.isMobile("18011357727");
        String date = DateUtil.format(new Date(), "yyyy-MM-dd");
        log.info("验证结果：中文-{},邮箱-{},手机-{},日期-{}",chinese,email,mobile,date);
    }
}
