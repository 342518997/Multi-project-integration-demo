package com.github.pengchong.shiro.remote;

import org.apache.shiro.session.Session;

import java.io.Serializable;

/**
 * 提供了会话的CRUD，及根据应用key和用户名获取权限上下文（
 * 包括角色和权限字符串）；
 * server模块服务端实现；
 * client模块客户端调用。
 * <p>User: peng chong
 * <p>Date: 17-12-22
 * <p>Version: 1.0
 */
public interface RemoteServiceInterface {

    public Session getSession(String appKey, Serializable sessionId);
    Serializable createSession(Session session);
    public void updateSession(String appKey, Session session);
    public void deleteSession(String appKey, Session session);
    public PermissionContext getPermissions(String appKey, String username);
}
