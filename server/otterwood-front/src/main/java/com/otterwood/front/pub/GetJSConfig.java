package com.otterwood.front.pub;

import com.otterwood.common.constants.Constants;
import com.otterwood.service.service.SystemConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: otterwood
 * @author: 大粽子
 * @create: 2021-09-23 09:18
 **/
@Slf4j
@RestController
@RequestMapping("api/public/jsconfig")
@Api(tags = "公共JS配置")
public class GetJSConfig {

    @Autowired
    private SystemConfigService systemConfigService;

    @PreAuthorize("hasAuthority('public:jsconfig:getotterwoodchatconfig')")
    @ApiOperation(value = "OTTERWOOD-chat客服统计")
    @RequestMapping(value = "/getotterwoodchatconfig", method = RequestMethod.GET)
    public String set(){
        return systemConfigService.getValueByKey(Constants.JS_CONFIG_OTTERWOOD_CHAT_TONGJI);
    }
}
