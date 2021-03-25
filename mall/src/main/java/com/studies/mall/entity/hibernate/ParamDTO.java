package com.studies.mall.entity.hibernate;

import com.studies.mall.common.dto.CommonDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ParamDTO extends CommonDTO {

    @ApiModelProperty("id")
    @NotBlank(message = "id不能为空")
    private String id;

    @ApiModelProperty("年龄")
    @NotNull(message = "年龄不能为空")
    @Range(min = 1, max = 120, message = "年龄必须为1-120岁")
    private Integer age;
}
