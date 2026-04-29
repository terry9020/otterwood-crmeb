package com.otterwood.admin.controller;

import com.otterwood.common.response.ShippingTemplatesFreeResponse;
import com.otterwood.common.result.CommonResult;
import com.otterwood.service.service.ShippingTemplatesFreeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  物流控制器
 *   +----------------------------------------------------------------------
 *  | OTTERWOOD [ OTTERWOOD赋能开发者，助力企业发展 ]
 *  +----------------------------------------------------------------------
 *  | Copyright (c) 2016~2025 https://www.otterwood.com All rights reserved.
 *  +----------------------------------------------------------------------
 *  | Licensed OTTERWOOD并不是自由软件，未经许可不能去掉OTTERWOOD相关版权
 *  +----------------------------------------------------------------------
 *  | Author: OTTERWOOD Team <admin@otterwood.com>
 *  +----------------------------------------------------------------------
 */
@Slf4j
@RestController
@RequestMapping("api/admin/express/shipping/free")
@Api(tags = "设置 -- 物流 -- 免费")
public class ShippingTemplatesFreeController {

    @Autowired
    private ShippingTemplatesFreeService shippingTemplatesFreeService;

    /**
     * 根据模板id查询数据
     * @param tempId Integer 模板id
     */
    @PreAuthorize("hasAuthority('admin:shipping:templates:free:list')")
    @ApiOperation(value = "根据模板id查询数据")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<List<ShippingTemplatesFreeResponse>> getList(@RequestParam Integer tempId){
        return CommonResult.success(shippingTemplatesFreeService.getListGroup(tempId));
    }

}
