package com.otterwood.service.service.impl;

import com.otterwood.common.request.PageParamRequest;
import com.otterwood.common.request.SmsApplyTempRequest;
import com.otterwood.common.request.SmsModifySignRequest;
import com.otterwood.common.vo.MyRecord;
import com.otterwood.service.service.SmsService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 * 短信服务实现（二开版）
 * <p>
 * 原版依赖一号通（sms.otterwood.net）提供短信发送、模板管理等功能。
 * 二开场景下已移除一号通全部代码，本类所有方法改为短路返回。
 * 如需启用短信功能，请自行接入第三方短信服务（阿里云、腾讯云等）。
 */
@Service
public class SmsServiceImpl implements SmsService {

    @Override
    public Boolean modifySign(SmsModifySignRequest request) {
        return false;
    }

    @Override
    public MyRecord temps(PageParamRequest pageParamRequest) {
        return new MyRecord();
    }

    @Override
    public Boolean applyTempMessage(SmsApplyTempRequest request) {
        return false;
    }

    @Override
    public MyRecord applys(Integer type, PageParamRequest pageParamRequest) {
        return new MyRecord();
    }

    @Override
    public Boolean sendCommonCode(String phone) {
        return false;
    }

    @Override
    public Boolean sendPaySuccess(String phone, String orderNo, BigDecimal payPrice, Integer msgTempId) {
        return false;
    }

    @Override
    public Boolean sendCreateOrderNotice(String phone, String orderNo, String realName, Integer msgTempId) {
        return false;
    }

    @Override
    public Boolean sendOrderPaySuccessNotice(String phone, String orderNo, String realName, Integer msgTempId) {
        return false;
    }

    @Override
    public Boolean sendOrderRefundApplyNotice(String phone, String orderNo, String realName, Integer msgTempId) {
        return false;
    }

    @Override
    public Boolean sendOrderReceiptNotice(String phone, String orderNo, String realName, Integer msgTempId) {
        return false;
    }

    @Override
    public Boolean sendOrderEditPriceNotice(String phone, String orderNo, BigDecimal price, Integer msgTempId) {
        return false;
    }

    @Override
    public Boolean sendOrderDeliverNotice(String phone, String nickName, String storeName, String orderNo, Integer msgTempId) {
        return false;
    }
}
