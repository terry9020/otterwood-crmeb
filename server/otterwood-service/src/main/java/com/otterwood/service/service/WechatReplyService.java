package com.otterwood.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.otterwood.common.request.PageParamRequest;
import com.otterwood.common.model.wechat.WechatReply;
import com.otterwood.common.request.WechatReplyRequest;
import com.otterwood.common.request.WechatReplySearchRequest;

import java.util.List;

/**
 *  WechatReplyService 接口
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
public interface WechatReplyService extends IService<WechatReply> {

    /**
     * 列表
     * @param request 请求参数
     * @param pageParamRequest 分页类参数
     * @return List<WechatReply>
     */
    List<WechatReply> getList(WechatReplySearchRequest request, PageParamRequest pageParamRequest);

    /**
     * 新增微信关键字回复表
     * @param wechatReply 新增参数
     */
    Boolean create(WechatReply wechatReply);

    /**
     * 根据关键字查询数据
     * @param keywords 新增参数
     * @return WechatReply
     */
    WechatReply getVoByKeywords(String keywords);

    /**
     * 查询微信关键字回复表信息
     * @param id Integer
     */
    WechatReply getInfo(Integer id);

    /**
     * 修改微信关键字回复表
     * @param wechatReplyRequest 修改参数
     */
    Boolean updateReply(WechatReplyRequest wechatReplyRequest);

    /**
     * 修改状态
     * @param id integer id
     * @param status boolean 状态
     */
    Boolean updateStatus(Integer id, Boolean status);
}
