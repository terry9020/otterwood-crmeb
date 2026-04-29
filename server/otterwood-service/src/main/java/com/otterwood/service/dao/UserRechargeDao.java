package com.otterwood.service.dao;

import com.otterwood.common.model.finance.UserRecharge;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.math.BigDecimal;

/**
 * 用户充值表 Mapper 接口
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
public interface UserRechargeDao extends BaseMapper<UserRecharge> {

    /**
     * 根据类型获取该类型充值总金额
     * @param type  充值类型
     * @return      该类型充值总金额
     */
    BigDecimal getSumByType(String type);

    /**
     * 获取退款总金额
     * @return 退款总金额
     */
    BigDecimal getSumByRefund();
}
