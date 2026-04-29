package com.otterwood.common.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询审核结果 Response
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
public class ShopAuditResultResponseVo extends BaseResultResponseVo {

    private ItemData data;

    @Data
    class ItemData{
        private Integer status;
        private Integer brand_id;
        private String reject_reason;
    }
}
