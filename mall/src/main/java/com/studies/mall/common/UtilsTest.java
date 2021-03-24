package com.studies.mall.common;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.crypto.digest.DigestUtil;
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

        String password = "123456";
        //计算MD5摘要值，并转为16进制字符串
        String result = DigestUtil.md5Hex(password);
        log.info("DigestUtil md5Hex:{}", result);
        //计算SHA-256摘要值，并转为16进制字符串
        result = DigestUtil.sha256Hex(password);
        log.info("DigestUtil sha256Hex:{}", result);
        //生成Bcrypt加密后的密文，并校验
        String hashPwd = DigestUtil.bcrypt(password);
        boolean check = DigestUtil.bcryptCheck(password,hashPwd);
        log.info("DigestUtil bcryptCheck:{}", check);
    }
}
