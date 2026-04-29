package com.otterwood.admin.controller;

import com.otterwood.common.model.product.StoreProductRule;
import com.otterwood.common.page.CommonPage;
import com.otterwood.common.request.PageParamRequest;
import com.otterwood.common.request.StoreProductRuleRequest;
import com.otterwood.common.request.StoreProductRuleSearchRequest;
import com.otterwood.common.result.CommonResult;
import com.otterwood.common.utils.OtterwoodUtil;
import com.otterwood.service.service.StoreProductRuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 商品规则值(规格)表 前端控制器
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
@Slf4j
@RestController
@RequestMapping("api/admin/store/product/rule")
@Api(tags = "商品 -- 规则值(规格)") //配合swagger使用
public class StoreProductRuleController {

    @Autowired
    private StoreProductRuleService storeProductRuleService;

    /**
     * 分页显示商品规则值(规格)表
     * @param request 搜索条件
     * @param pageParamRequest 分页参数
     */
    @PreAuthorize("hasAuthority('admin:product:rule:list')")
    @ApiOperation(value = "分页列表") //配合swagger使用
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<StoreProductRule>> getList(
            @Validated StoreProductRuleSearchRequest request, @Validated PageParamRequest pageParamRequest) {
        CommonPage<StoreProductRule> storeProductRuleCommonPage =
                CommonPage.restPage(storeProductRuleService.getList(request, pageParamRequest));
        return CommonResult.success(storeProductRuleCommonPage);
    }

    /**
     * 新增商品规则值(规格)表
     * @param storeProductRuleRequest 新增参数
     */
    @PreAuthorize("hasAuthority('admin:product:rule:save')")
    @ApiOperation(value = "新增")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public CommonResult<String> save(@RequestBody @Validated StoreProductRuleRequest storeProductRuleRequest) {
        if (storeProductRuleService.save(storeProductRuleRequest)) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    /**
     * 删除商品规则值(规格)表
     * @param ids Integer
     */
    @PreAuthorize("hasAuthority('admin:product:rule:delete')")
    @ApiOperation(value = "删除")
    @RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
    public CommonResult<String> delete(@PathVariable String ids) {
        if (storeProductRuleService.removeByIds(OtterwoodUtil.stringToArray(ids))) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    /**
     * 修改商品规则值(规格)表
     * @param storeProductRuleRequest 修改参数
     */
    @PreAuthorize("hasAuthority('admin:product:rule:update')")
    @ApiOperation(value = "修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CommonResult<String> update(@RequestBody @Validated StoreProductRuleRequest storeProductRuleRequest) {
        if (storeProductRuleService.updateRule(storeProductRuleRequest)) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    /**
     * 查询商品规则值(规格)表信息
     * @param id Integer
     */
    @PreAuthorize("hasAuthority('admin:product:rule:info')")
    @ApiOperation(value = "详情")
    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public CommonResult<StoreProductRule> info(@PathVariable Integer id) {
        StoreProductRule storeProductRule = storeProductRuleService.getById(id);
        return CommonResult.success(storeProductRule);
   }
}



