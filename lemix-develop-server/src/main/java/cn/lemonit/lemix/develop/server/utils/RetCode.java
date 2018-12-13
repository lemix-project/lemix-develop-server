package cn.lemonit.lemix.develop.server.utils;
//枚举
public enum RetCode {
    // 成功
    SUCCESS(0),

    // 失败
    FAIL(10000),

    // 未认证（签名错误）
    UNAUTHORIZED(401),

    // 接口不存在
    NOT_FOUND(404),

    // 服务器内部错误
    INTERNAL_SERVER_ERROR(500);

    public Integer code;

    RetCode(Integer code) {
        this.code = code;
    }
}
