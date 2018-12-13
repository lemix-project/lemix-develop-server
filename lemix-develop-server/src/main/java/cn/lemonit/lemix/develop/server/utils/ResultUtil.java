package cn.lemonit.lemix.develop.server.utils;


import cn.lemonit.lemix.develop.server.entity.Result;

public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(0);
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, boolean success) {
        Result result = new Result();
        result.setSuccess(success);
        result.setCode(code);
        result.setData(null);
        return result;
    }
}
