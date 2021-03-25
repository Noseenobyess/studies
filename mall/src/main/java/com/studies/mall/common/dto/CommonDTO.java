package com.studies.mall.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CommonDTO implements Serializable {
    private static final long serialVersionUID = 2184566123021708552L;

    //创建人
    @ApiModelProperty("创建人")
    private String createdBy;

    //创建时间
    @ApiModelProperty("创建时间")
    private Date createdDate;

    //修改人
    @ApiModelProperty("更新人")
    private String updatedBy;

    //修改时间
    @ApiModelProperty("更新时间")
    private Date updatedDate;

    //单页数量
    @ApiModelProperty("单页数量")
    private Integer pageSize;

    //页码
    @ApiModelProperty("页码")
    private Integer pageNum;
}
