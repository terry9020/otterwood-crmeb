package com.otterwood.admin.task.wechat;

import com.otterwood.common.utils.OtterwoodDateUtil;
import com.otterwood.service.service.TemplateMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 公众号消费队列消费
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
@Component("AsyncWeChatPublicTempMessage")
public class AsyncWeChatPublicTempMessage {
    //日志
    private static final Logger logger = LoggerFactory.getLogger(AsyncWeChatPublicTempMessage.class);

    @Autowired
    private TemplateMessageService templateMessageService;

    //1分钟同步一次数据
    public void init() {
        logger.info("---AsyncWeChatPublicTempMessage task------produce Data with fixed rate task: Execution Time - {}", OtterwoodDateUtil.nowDate());
        try {
            templateMessageService.consumePublic();

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("AsyncWeChatPublicTempMessage.task" + " | msg : " + e.getMessage());
        }

    }
}
