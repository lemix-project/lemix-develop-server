package cn.lemonit.lemix.develop.server.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Lmx_Version {
    private int version_id;
    private String version_key;
    private String app_key;
    private String version_tag;
    private Date update_time;
    private int app_id;

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public int getVersion_id() {
        return version_id;
    }

    public void setVersion_id(int version_id) {
        this.version_id = version_id;
    }

    public String getVersion_key() {
        return version_key;
    }

    public void setVersion_key(String version_key) {
        this.version_key = version_key;
    }

    public String getApp_key() {
        return app_key;
    }

    public void setApp_key(String app_key) {
        this.app_key = app_key;
    }

    public String getVersion_tag() {
        return version_tag;
    }

    public void setVersion_tag(String version_tag) {
        this.version_tag = version_tag;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }





}
