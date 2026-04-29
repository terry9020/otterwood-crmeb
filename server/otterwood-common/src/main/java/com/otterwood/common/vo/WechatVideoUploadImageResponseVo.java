package com.otterwood.common.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
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
@EqualsAndHashCode(callSuper = true)
@Data
public class WechatVideoUploadImageResponseVo extends BaseResultResponseVo {

    private WechatVideoUploadImageInfoVo img_info;
}
