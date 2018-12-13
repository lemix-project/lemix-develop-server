package cn.lemonit.lemix.develop.server.dao;

import cn.lemonit.lemix.develop.server.entity.Lmx_Version;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Lmx_VersionMapper {
    //增，上传版本
    int add(Lmx_Version lmx_version);
    //查
    List<Lmx_Version> list();
}
