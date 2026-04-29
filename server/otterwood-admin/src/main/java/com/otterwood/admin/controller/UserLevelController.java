package com.otterwood.admin.controller;

import com.otterwood.common.model.user.UserLevel;
import com.otterwood.common.page.CommonPage;
import com.otterwood.common.request.PageParamRequest;
import com.otterwood.common.result.CommonResult;
import com.otterwood.service.service.UserLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户等级记录表 前端控制器
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
@RequestMapping("api/admin/user/level")
@Api(tags = "会员 -- 等级")
public class UserLevelController {

    @Autowired
    private UserLevelService userLevelService;

    /**
     * 分页显示用户等级记录表
     * @param pageParamRequest 分页参数
     */
    @PreAuthorize("hasAuthority('admin:user:level:list')")
    @ApiOperation(value = "分页列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<UserLevel>> getList(@Validated PageParamRequest pageParamRequest) {
        CommonPage<UserLevel> userLevelCommonPage = CommonPage.restPage(userLevelService.getList(pageParamRequest));
        return CommonResult.success(userLevelCommonPage);
    }
}



