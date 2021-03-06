package cn.lemonit.lemix.develop.server.service;

import cn.lemonit.lemix.develop.server.entity.Lmx_App;

import java.util.List;

public interface Lmx_AppService {
    //创建应用
    int  add(Lmx_App lmx_app);
    //判断app_id是否存在
    int selectApp_Id(int id);
    //删除应用
    void delete(int app_id);
    //修改应用信息
    int update(Lmx_App lmx_app);
    //通过app_key查找app_name
    List<Lmx_App> selectApp_name(String app_key);
}
