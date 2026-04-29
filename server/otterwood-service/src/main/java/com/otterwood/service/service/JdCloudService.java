package com.otterwood.service.service;


/**
 * 京东云 Service
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
public interface JdCloudService {

    /**
     * 文件上传
     * @param fileName 文件名称
     * @param localFilePath 本地文件地址
     * @param bucket 存储桶名称
     */
    void uploadFile(String fileName, String localFilePath, String bucket);

    /**
     * 创建新的存储空间
     */
    void createBucket(String bucketName);

    /**
     * 获取文件URL
     * @param bucket 存储桶名称
     * @param fileName 文件名称
     */
    String getUrl(String bucket, String fileName);
}
