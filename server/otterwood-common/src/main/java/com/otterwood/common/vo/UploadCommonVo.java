package com.otterwood.common.vo;

import lombok.Data;

/**
 * 文件公共上传对象
 *
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
@Data
public class UploadCommonVo {

    //服务器存储地址
    private String rootPath;

    //类型
    private String type;

    //模块
    private String modelPath;

    //扩展名
    private String extStr;

    //文件大小上限
    private int size;

}
