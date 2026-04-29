package com.otterwood.common.vo;

import lombok.Data;

/**
 * 短信发送api第三方参数实体类
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
public class SendSmsVo {
    private String uid;
    private String token;

    // 待发送短信手机号
    private String mobile;

    // 模版id
    private Integer template;

    // 发送参数
    private String param;

    private String content;

}
