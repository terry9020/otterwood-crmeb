package com.otterwood.common.exception;

import com.otterwood.common.result.CommonResultCode;
import com.otterwood.common.result.IResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Otterwood异常类
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
@Slf4j
@RestControllerAdvice
public class OtterwoodException extends RuntimeException {

    private static final long serialVersionUID = 6397082987802748517L;

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String message;

    public OtterwoodException() {
        super();
    }

    public OtterwoodException(String message) {
        super(CommonResultCode.ERROR.getCode() + "-" + message);
        this.code = CommonResultCode.ERROR.getCode();
        this.message = message;
    }

    public OtterwoodException(IResultEnum iResultEnum) {
        super(iResultEnum.getCode() + "-" + iResultEnum.getMessage());
        this.code = iResultEnum.getCode();
        this.message = iResultEnum.getMessage();
    }

    public OtterwoodException(IResultEnum iResultEnum, String message) {
        super(iResultEnum.getCode() + "-" + message);
        this.code = iResultEnum.getCode();
        this.message = message;
    }

    public OtterwoodException(IResultEnum iResultEnum, Throwable throwable) {
        super(iResultEnum.getCode() + "-" + iResultEnum.getMessage() + ", " + throwable.getMessage(), throwable);
        this.code = iResultEnum.getCode();
        this.message = iResultEnum.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
