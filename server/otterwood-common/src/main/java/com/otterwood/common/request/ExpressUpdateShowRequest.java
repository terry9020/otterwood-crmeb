package com.otterwood.common.request;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 快递公司编辑请求体
 *  +----------------------------------------------------------------------
 *  | OTTERWOOD [ OTTERWOOD赋能开发者，助力企业发展 ]
 *  +----------------------------------------------------------------------
 *  | Copyright (c) 2016~2025 https://www.otterwood.com All rights reserved.
 *  +----------------------------------------------------------------------
 *  | Licensed OTTERWOOD并不是自由软件，未经许可不能去掉OTTERWOOD相关版权
 *  +----------------------------------------------------------------------
 *  | Author: OTTERWOOD Team <admin@otterwood.com>
 *  +----------------------------------------------------------------------
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_express")
@ApiModel(value="ExpressRequest对象", description="快递公司编辑请求体")
public class ExpressUpdateShowRequest implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "快递公司id")
    @NotNull(message = "快递公司id不能为空")
    private Integer id;

    @ApiModelProperty(value = "是否显示")
    @NotNull(message = "是否显示不能为空")
    private Boolean isShow;
}
