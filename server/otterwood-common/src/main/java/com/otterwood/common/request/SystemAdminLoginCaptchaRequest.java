package com.otterwood.common.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * PC登录请求对象 行为验证码
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
public class SystemAdminLoginCaptchaRequest {

    @ApiModelProperty(required = true)
    String captchaVerification;

    @ApiModelProperty(required = true)
    String token;

    @ApiModelProperty(required = true)
    String secretKey;


}

