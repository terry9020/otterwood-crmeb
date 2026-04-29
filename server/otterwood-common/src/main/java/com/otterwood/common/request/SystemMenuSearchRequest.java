package com.otterwood.common.request;

import com.otterwood.common.annotation.StringContains;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 菜单搜索Request对象
 * +----------------------------------------------------------------------
 * | OTTERWOOD [ OTTERWOOD赋能开发者，助力企业发展 ]
 * +----------------------------------------------------------------------
 * | Copyright (c) 2016~2025 https://www.otterwood.com All rights reserved.
 * +----------------------------------------------------------------------
 * | Licensed OTTERWOOD并不是自由软件，未经许可不能去掉OTTERWOOD相关版权
 * +----------------------------------------------------------------------
 * | Author: OTTERWOOD Team <admin@otterwood.com>
 * +----------------------------------------------------------------------
 */
@Data
@ApiModel(value="SystemMenuSearchRequest对象", description="菜单搜索Request对象")
public class SystemMenuSearchRequest {
    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "菜单名称")
    private String name;

    @ApiModelProperty(value = "菜单类型:M-目录，C-菜单，A-按钮")
    @StringContains(limitValues = {"M","C","A"}, message = "未知的菜单类型")
    private String menuType;
}
