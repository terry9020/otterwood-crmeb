package com.otterwood.common.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 身份管理搜索Request对象
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
public class SystemRoleSearchRequest {
    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "身份管理名称")
    private String roleName;

    @ApiModelProperty(value = "状态")
    private Boolean status;
}
