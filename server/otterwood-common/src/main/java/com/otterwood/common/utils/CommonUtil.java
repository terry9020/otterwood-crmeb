package com.otterwood.common.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 通用工具类
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
public class CommonUtil {

    /**
     * 随机生成密码
     *
     * @param phone 手机号
     * @return 密码
     * 使用des方式加密
     */
    public static String createPwd(String phone) {
        String password = "Abc" + OtterwoodUtil.randomCount(10000, 99999);
        return OtterwoodUtil.encryptPassword(password, phone);
    }

    /**
     * 随机生成用户昵称
     *
     * @param phone 手机号
     * @return 昵称
     */
    public static String createNickName(String phone) {
        return DigestUtils.md5Hex(phone + OtterwoodDateUtil.getNowTime()).
                subSequence(0, 12).
                toString();
    }

}
