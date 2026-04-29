package com.otterwood.common.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 签到记录表
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("eb_user_sign")
@ApiModel(value="UserSign对象", description="签到记录表")
public class UserSignMonthVo implements Serializable {

    private static final long serialVersionUID=1L;

    public UserSignMonthVo() {}
    public UserSignMonthVo(String month, List<UserSignVo> list) {
        this.month = month;
        this.list = list;
    }

    @ApiModelProperty(value = "月")
    private String month;

    @ApiModelProperty(value = "签到列表")
    private List<UserSignVo> list;
}
