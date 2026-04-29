package com.otterwood.front.pub;

import com.otterwood.common.constants.CopyrightConstants;
import com.otterwood.common.response.CopyRightResponse;
import com.otterwood.common.response.PayConfigResponse;
import com.otterwood.common.result.CommonResult;
import com.otterwood.service.service.SystemConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公开设置控制器
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
@RequestMapping("api/public/config")
@Api(tags = "公开设置控制器")
public class PubliclyConfigController {

    @Autowired
    private SystemConfigService systemConfigService;

    @ApiOperation(value = "获取版权")
    @RequestMapping(value = "/get/copyright", method = RequestMethod.GET)
    public CommonResult<CopyRightResponse> getCopyright() {
        CopyRightResponse copyRightResponse = new CopyRightResponse();
        copyRightResponse.setCopyrightIcpNumber(systemConfigService.getValueByKey(CopyrightConstants.COPYRIGHT_ICP_NUMBER));
        copyRightResponse.setCopyrightIcpNumberUrl(systemConfigService.getValueByKey(CopyrightConstants.COPYRIGHT_ICP_NUMBER_URL));
        copyRightResponse.setCopyrightInternetRecord(systemConfigService.getValueByKey(CopyrightConstants.COPYRIGHT_INTERNET_RECORD));
        copyRightResponse.setCopyrightInternetRecordUrl(systemConfigService.getValueByKey(CopyrightConstants.COPYRIGHT_INTERNET_RECORD_URL));
        return CommonResult.success(copyRightResponse);
    }

    @ApiOperation(value = "获取移动端域名")
    @RequestMapping(value = "/get/front/domain", method = RequestMethod.GET)
    public CommonResult<String> getFrontDomain() {
        return CommonResult.success(systemConfigService.getFrontDomain());
    }

    @ApiOperation(value = "获取平台当前的素材地址")
    @RequestMapping(value = "/get/admin/mediadomain", method = RequestMethod.GET)
    public CommonResult<String> getMediaDomain() {
        return CommonResult.success(systemConfigService.getMediaDomain());
    }


}
