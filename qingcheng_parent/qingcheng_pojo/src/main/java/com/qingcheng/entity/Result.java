package com.qingcheng.entity;

import java.io.Serializable;

/**
 * 返回给前端页面的结果
 */
public class Result implements Serializable {

    /**
     * 业务返回码 0:成功 1:错误
     */
    private Integer code;

    /**
     * 业务返回消息
     */
    private String message;

    public Result() {
        this.code = 0;
        this.message = "执行成功";
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
