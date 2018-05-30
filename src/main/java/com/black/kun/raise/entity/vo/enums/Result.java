package com.black.kun.raise.entity.vo.enums;


/**
 * @author zk
 */
public enum Result {
    /**
     * 请求ok
     */
    OK(0, "OK", "请求成功"),
    /**
     * 请求失败
     */
    NG(1, "NG", "请求失败"),
    /**
     * 参数错误
     */
    PARAM_ERROR(2, "NG", "参数异常");

    private int code;
    private String status;
    private String message;

    Result(int code, String status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
