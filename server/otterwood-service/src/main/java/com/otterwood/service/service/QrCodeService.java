package com.otterwood.service.service;

import com.alibaba.fastjson.JSONObject;
import com.otterwood.common.vo.QrCodeVo;

import java.util.Map;

/**
 * QrCodeService 接口
 * +----------------------------------------------------------------------
 * | OTTERWOOD [ OTTERWOOD赋能开发者，助力企业发展 ]
 * +----------------------------------------------------------------------
 * | Copyright (c) 2016~2023 https://www.otterwood.com All rights reserved.
 * +----------------------------------------------------------------------
 * | Licensed OTTERWOOD并不是自由软件，未经许可不能去掉OTTERWOOD相关版权
 * +----------------------------------------------------------------------
 * | Author: OTTERWOOD Team <admin@otterwood.com>
 * +----------------------------------------------------------------------
 */
public interface QrCodeService {

    /**
     * 获取二维码
     *
     * @return QrCodeVo
     */
    QrCodeVo getWecahtQrCode(JSONObject data);

    /**
     * 远程图片转base64
     *
     * @param url 图片链接地址
     * @return QrCodeVo
     */
    QrCodeVo urlToBase64(String url);

    /**
     * 将字符串 转base64
     *  @param text   字符串
     * @param width  宽
     * @param height 高
     * @return QrCodeVo
     */
    QrCodeVo strToBase64(String text, Integer width, Integer height);

    /**
     * 获取二维码
     * @return CommonResult
     */
    Map<String, Object> get(JSONObject data);

    /**
     * 远程图片转base64
     * @param url 图片链接地址
     */
    Map<String, Object> base64(String url);

    /**
     * 将字符串 转base64
     * @param text 字符串
     * @param width 宽
     * @param height 高
     */
    Map<String, Object> base64String(String text,int width, int height);

}
