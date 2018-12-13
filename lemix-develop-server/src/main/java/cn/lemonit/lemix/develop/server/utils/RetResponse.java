package cn.lemonit.lemix.develop.server.utils;

import cn.lemonit.lemix.develop.server.entity.Result;
//数据封装
public class RetResponse {


    public static <T> Result<T> makeOKRsp() {
         return new Result<T>().setCode(RetCode.SUCCESS).setSuccess(true);
    }

    public static <T> Result<T> makeOKRsp(T data) {
        return new Result<T>().setCode(RetCode.SUCCESS).setSuccess(true).setData(data);
    }

    public static <T> Result<T> makeErrRsp(String message) {
        return new Result<T>().setCode(RetCode.FAIL).setSuccess(true);
    }

    public static <T> Result<T> makeRsp(Integer code, boolean success ) {
        return new Result<T>().setCode(code).setSuccess(success);
    }

    public static <T> Result<T> makeRsp(Integer code, boolean success, T data) {
        return new Result<T>().setCode(code).setSuccess(success).setData(data);
    }
}
