package cn.lemonit.lemix.develop.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component

public class Lmx_App {
    private int app_id;
    private String app_key;
    private String app_name;
    private String app_introduce;
    private Date app_create_time;
    private List<Lmx_Version> lmx_versionList;


    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }
    public String getApp_key() {
        return app_key;
    }

    public void setApp_key(String app_key) {
        this.app_key = app_key;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getApp_introduce() {
        return app_introduce;
    }

    public void setApp_introduce(String app_introduce) {
        this.app_introduce = app_introduce;
    }

    public Date getApp_create_time() {
        return app_create_time;
    }

    public void setApp_create_time(Date app_create_time) {
        this.app_create_time = app_create_time;
    }
}
