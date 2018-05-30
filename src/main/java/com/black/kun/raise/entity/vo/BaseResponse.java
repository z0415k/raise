package com.black.kun.raise.entity.vo;

import com.black.kun.raise.entity.vo.enums.Result;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zk
 */
@Data
@AllArgsConstructor
public class BaseResponse<T> {
    private int code;
    private String status;
    private String message;
    private T content;

    public BaseResponse(Result result) {
        this.code = result.getCode();
        this.status = result.getStatus();
        this.message = result.getMessage();
    }

    public BaseResponse(Result result, T content) {
        this(result);
        this.content = content;
    }

    public BaseResponse() {
        this(Result.OK);
        this.content = null;
    }
    public BaseResponse(T content) {
        this(Result.OK);
        this.content = content;
    }
}
