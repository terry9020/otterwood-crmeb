package com.otterwood.admin.controller;

import com.otterwood.admin.copyright.CopyrightInfoResponse;
import com.otterwood.admin.copyright.CopyrightUpdateInfoRequest;
import com.otterwood.admin.service.CopyrightService;
import com.otterwood.common.result.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 版权控制器
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
@RequestMapping("api/admin/copyright")
@Api(tags = "版权控制器")
public class CopyrightController {

    @Autowired
    private CopyrightService copyrightService;

    @PreAuthorize("hasAuthority('admin:copyright:get:info')")
    @ApiOperation(value = "获取版权信息")
    @RequestMapping(value = "/get/info", method = RequestMethod.GET)
    public CommonResult<CopyrightInfoResponse> getInfo() {
        return CommonResult.success(copyrightService.getInfo());
    }

}
