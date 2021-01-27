package com.studies.mall.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class UserDTO extends BaseRowModel {

    @ExcelProperty(value = "工号",index = 0)
    private Integer worknumber;

    @ExcelProperty(value = "姓名",index = 1)
    private String name;

    @ExcelProperty(value = "手机号",index = 2)
    private String phone;

    @ExcelProperty(value = "身份证",index = 4)
    private String idcard;

    @ExcelProperty(value = "生日",index = 3)
    private String birthday;
}