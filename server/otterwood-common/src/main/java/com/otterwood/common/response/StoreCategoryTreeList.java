package com.otterwood.common.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * StoreCategoryTreeList
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
public class StoreCategoryTreeList {
    private static final long serialVersionUID=1L;

    private Integer id;

    private Integer pid;

    private String cateName;

    private Integer sort;

    private String pic;

    private Boolean isShow;

    private Integer addTime;

    private List<StoreCategoryTreeList> child = new ArrayList<>();
}
