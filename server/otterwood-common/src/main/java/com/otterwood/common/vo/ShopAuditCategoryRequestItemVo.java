package com.otterwood.common.vo;

import lombok.Data;

/**
 * 上传类目资质Item
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
public class ShopAuditCategoryRequestItemVo {
    // 营业执照或组织机构代码证，图片url
    private String license;
    // Response ItemData
    private ShopAuditCategoryRequestItemDataVo category_info;
}
