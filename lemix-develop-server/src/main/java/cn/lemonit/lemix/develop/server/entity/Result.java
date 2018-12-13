package cn.lemonit.lemix.develop.server.entity;

import cn.lemonit.lemix.develop.server.utils.RetCode;

public class Result<T> {
    private Integer code;
    private boolean success;
    private T data;

    public Result<T> setCode(RetCode retCode) {
        this.code = retCode.code;
        return this;
    }
    public boolean isSuccess() {
        return success;
    }

    public Result<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public Result<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }
}
