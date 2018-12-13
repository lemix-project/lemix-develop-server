package cn.lemonit.lemix.develop.server.service;

import cn.lemonit.lemix.develop.server.entity.Lmx_Version;

import java.util.List;

public interface Lmx_VersionService {
    //增，上传版本
    int add(Lmx_Version lmx_version);
    //查
    List<Lmx_Version> list();
}
