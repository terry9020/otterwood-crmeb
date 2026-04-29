package com.otterwood.common.response;

import com.otterwood.common.model.user.UserBill;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 用户余额账单记录
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
@Accessors(chain = true)
@ApiModel(value="UserRechargeBillRecordResponse对象", description="用户余额账单记录")
public class UserRechargeBillRecordResponse implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "月份")
    private String date;

    @ApiModelProperty(value = "数据")
    private List<UserBill> list;
}
