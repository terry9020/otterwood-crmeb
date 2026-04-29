package com.otterwood.common.response;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 砍价用户帮助响应体
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
public class StoreBargainUserHelpResponse implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "砍价用户帮助表ID")
    private Integer id;

    @ApiModelProperty(value = "帮助的用户id")
    private Integer uid;

    @ApiModelProperty(value = "砍价商品ID")
    private Integer bargainId;

    @ApiModelProperty(value = "用户参与砍价表id")
    private Integer bargainUserId;

    @ApiModelProperty(value = "帮助砍价多少金额")
    private BigDecimal price;

    @ApiModelProperty(value = "添加时间")
    private String addTime;

    @ApiModelProperty(value = "用户头像")
    private String avatar;

    @ApiModelProperty(value = "用户昵称")
    private String nickname;


}
