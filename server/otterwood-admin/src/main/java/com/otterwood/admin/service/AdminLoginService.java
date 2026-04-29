package com.otterwood.admin.service;

import com.otterwood.common.request.LoginAdminUpdatePasswordRequest;
import com.otterwood.common.request.LoginAdminUpdateRequest;
import com.otterwood.common.request.SystemAdminLoginRequest;
import com.otterwood.common.response.MenusResponse;
import com.otterwood.common.response.SystemAdminResponse;
import com.otterwood.common.response.SystemLoginResponse;

import java.util.List;
import java.util.Map;

/**
 * 管理端登录服务
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
public interface AdminLoginService {

    /**
     * PC登录
     */
    SystemLoginResponse login(SystemAdminLoginRequest request, String ip);

    /**
     * 用户登出
     */
    Boolean logout();

    /**
     * 获取登录页图片
     * @return Map
     */
    Map<String, Object> getLoginPic();

    /**
     * 获取管理员可访问目录
     * @return List<MenusResponse>
     */
    List<MenusResponse> getMenus();

    /**
     * 根据Token获取对应用户信息
     */
    SystemAdminResponse getInfoByToken();

    /**
     * 账号登录检测
     * @param account 账号
     * @return 账号错误登录次数
     */
    Integer accountDetection(String account);

    /**
     * 修改登录用户信息
     *
     * @param request 请求参数
     * @return Boolean
     */
    Boolean loginAdminUpdate(LoginAdminUpdateRequest request);


    /**
     * 修改登录用户密码
     */
    Boolean loginAdminUpdatePwd(LoginAdminUpdatePasswordRequest request);
}
