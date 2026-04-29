package com.otterwood.common.vo;

import lombok.Data;

import java.util.List;

/**
 * 第二级类目
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
@Data
public class SecondCatVo {

    /** 二级类目ID */
    private Integer secondCatId;

    /** 二级类目名称 */
    private String secondCatName;

    /** 三级类目数组 */
    private List<ThirdCatVo> thirdCatList;
}
