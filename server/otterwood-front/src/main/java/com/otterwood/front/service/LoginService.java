package com.otterwood.front.service;

import com.otterwood.common.model.user.User;
import com.otterwood.common.request.LoginMobileRequest;
import com.otterwood.common.request.LoginRequest;
import com.otterwood.common.response.LoginConfigResponse;
import com.otterwood.common.response.LoginResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * 移动端登录服务类
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
public interface LoginService {

    /**
     * 账号密码登录
     *
     * @return LoginResponse
     */
    LoginResponse login(LoginRequest loginRequest);

    /**
     * 手机号验证码登录
     */
    LoginResponse phoneLogin(LoginMobileRequest loginRequest);

    /**
     * 老绑定分销关系
     *
     * @param user      User 用户user类
     * @param spreadUid Integer 推广人id
     * @return Boolean
     */
    Boolean bindSpread(User user, Integer spreadUid);

    /**
     * 推出登录
     *
     * @param request HttpServletRequest
     */
    void loginOut(HttpServletRequest request);

    /**
     * 校验token是否有效
     *
     * @return true 有效， false 无效
     */
    Boolean tokenIsExist();

    /**
     * 获取登录配置
     */
    LoginConfigResponse getLoginConfig();
}
