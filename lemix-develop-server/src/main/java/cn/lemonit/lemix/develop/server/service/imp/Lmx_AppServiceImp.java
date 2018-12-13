package cn.lemonit.lemix.develop.server.service.imp;

import cn.lemonit.lemix.develop.server.dao.Lmx_AppMapper;
import cn.lemonit.lemix.develop.server.entity.Lmx_App;
import cn.lemonit.lemix.develop.server.service.Lmx_AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Lmx_AppServiceImp implements Lmx_AppService {
    @Autowired
    private Lmx_AppMapper lmx_appMapper;
    @Override
    public int add(Lmx_App lmx_app) {
        return lmx_appMapper.add(lmx_app);
    }

    @Override
    public int selectApp_Id(int id) {
        return lmx_appMapper.selectApp_Id(id);
    }

    @Override
    public void delete(int app_id) {
        lmx_appMapper.delete(app_id);
    }

    @Override
    public int update(Lmx_App lmx_app) {
        return lmx_appMapper.update(lmx_app);
    }

    @Override
    public List<Lmx_App> selectApp_name(String app_key) {
        return lmx_appMapper.selectApp_name(app_key);
    }


}
