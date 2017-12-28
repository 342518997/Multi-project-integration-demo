package com.github.pengchong.service;


import com.github.pengchong.dao.AppDao;
import com.github.pengchong.entity.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@Service

public class AppServiceImpl implements AppService {

    @Autowired
    private AppDao appDao;

    public App createApp(App app) {
        return appDao.createApp(app);
    }

    public App updateApp(App app) {
        return appDao.updateApp(app);
    }

    public void deleteApp(Long appId) {
        appDao.deleteApp(appId);
    }


    public App findOne(Long appId) {
        return appDao.findOne(appId);
    }


    public List<App> findAll() {
        return appDao.findAll();
    }


    public Long findAppIdByAppKey(String appKey) {
        return appDao.findAppIdByAppKey(appKey);
    }
}