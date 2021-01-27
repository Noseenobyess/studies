package com.studies.mall;

import com.alibaba.excel.EasyExcel;
import com.studies.mall.entity.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class EasyExcelTest {

    @Test
    public static void main(String[] args) {
        List<UserDTO> userList = new ArrayList<>();
        for (int i = 0;i<100;i++){
            UserDTO user = UserDTO.builder().worknumber(i).
                    birthday("2020-11-11").idcard("1234").phone("1300000000"+i).name("测试名称"+i).build();
            userList.add(user);
        }
        String fileName =  "F:\\EasyExcel.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, UserDTO.class).sheet("模板").doWrite(userList);
    }
}
