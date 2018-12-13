package cn.lemonit.lemix.develop.server.service.imp;

import cn.lemonit.lemix.develop.server.dao.Lmx_VersionMapper;
import cn.lemonit.lemix.develop.server.entity.Lmx_Version;
import cn.lemonit.lemix.develop.server.service.Lmx_VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Lmx_VersionServiceImp implements Lmx_VersionService {
    @Autowired
    private Lmx_VersionMapper lmx_versionMapper;
    @Override
    public int add(Lmx_Version lmx_version) {
         return lmx_versionMapper.add(lmx_version);
    }

    @Override
    public List<Lmx_Version> list() {
        return lmx_versionMapper.list();
    }
}
