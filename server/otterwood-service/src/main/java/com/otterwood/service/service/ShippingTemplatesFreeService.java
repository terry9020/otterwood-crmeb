package com.otterwood.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.otterwood.common.model.express.ShippingTemplatesFree;
import com.otterwood.common.request.ShippingTemplatesFreeRequest;
import com.otterwood.common.response.ShippingTemplatesFreeResponse;

import java.util.List;

/**
 * ShippingTemplatesFreeService 接口
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
public interface ShippingTemplatesFreeService extends IService<ShippingTemplatesFree> {

    Boolean saveAll(List<ShippingTemplatesFreeRequest> shippingTemplatesFreeRequestList, Integer type, Integer id);

    List<ShippingTemplatesFreeResponse> getListGroup(Integer tempId);

    /**
     * 删除
     *
     * @param tempId 运费模板id
     */
    Boolean deleteByTempId(Integer tempId);

    /**
     * 根据模板编号、城市ID查询
     *
     * @param tempId 模板编号
     * @param cityId 城市ID
     * @return 运费模板
     */
    ShippingTemplatesFree getByTempIdAndCityId(Integer tempId, Integer cityId);
}
