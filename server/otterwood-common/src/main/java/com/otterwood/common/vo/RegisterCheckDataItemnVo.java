package com.otterwood.common.vo;

import lombok.Data;

/**
 * RegisterCheckAccessInfoItemVo 获取接入状态Response
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
public class RegisterCheckDataItemnVo {
    // 审核状态, 2: 已接入, 3: 封禁中
    private Integer status;
    private RegisterCheckAccessInfoItemVo access_info;
}
