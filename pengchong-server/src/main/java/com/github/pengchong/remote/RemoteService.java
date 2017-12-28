package com.github.pengchong.remote;


import com.github.pengchong.service.AuthorizationService;
import com.github.pengchong.shiro.remote.PermissionContext;
import com.github.pengchong.shiro.remote.RemoteServiceInterface;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * <p>User: pengchong 
 * <p>Date: 14-3-13
 * <p>Version: 1.0
 */
public class RemoteService implements RemoteServiceInterface {

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private SessionDAO sessionDAO;

 
    public Session getSession(String appKey, Serializable sessionId) {
        return sessionDAO.readSession(sessionId);
    }

    
    public Serializable createSession(Session session) {
        return sessionDAO.create(session);
    }

    
    public void updateSession(String appKey, Session session) {
        sessionDAO.update(session);
    }

    
    public void deleteSession(String appKey, Session session) {
        sessionDAO.delete(session);
    }

    
    public PermissionContext getPermissions(String appKey, String username) {
        PermissionContext permissionContext = new PermissionContext();
        permissionContext.setRoles(authorizationService.findRoles(appKey, username));
        permissionContext.setPermissions(authorizationService.findPermissions(appKey, username));
        return permissionContext;
    }
}
