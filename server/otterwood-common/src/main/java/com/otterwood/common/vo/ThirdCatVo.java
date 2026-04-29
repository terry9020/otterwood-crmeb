package com.otterwood.common.vo;

import lombok.Data;

/**
 * 第三级类目
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
public class ThirdCatVo {

    /** 类目ID */
    private Integer thirdCatId;

    /** 类目名称 */
    private String thirdCatName;

    /** 类目资质 */
    private String qualification;

    /** 类目资质类型,0:不需要,1:必填,2:选填 */
    private Integer qualificationType;

    /** 商品资质 */
    private String productQualification;

    /** 商品资质类型,0:不需要,1:必填,2:选填 */
    private Integer productQualificationType;

}
