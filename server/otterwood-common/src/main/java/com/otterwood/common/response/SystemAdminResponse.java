package com.otterwood.common.response;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统管理员Response对象
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
public class SystemAdminResponse implements Serializable {

    private Integer id;

    private String account;

//    private String pwd;

    private String realName;

    private String roles;

    private String roleNames;

    private String lastIp;

    private Date lastTime;

    private Integer addTime;

    private Integer loginCount;

    private Integer level;

    private Boolean status;

//    private Boolean isDel;

    private String Token;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "是否接收短信")
    private Boolean isSms;

    @ApiModelProperty(value = "权限标识数组")
    private List<String> permissionsList;
}
