package com.github.pengchong.dao;



import com.github.pengchong.entity.Authorization;

import java.util.List;

/**
 * <p>User: peng chong
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface AuthorizationDao {

    public Authorization createAuthorization(Authorization authorization);
    public Authorization updateAuthorization(Authorization authorization);
    public void deleteAuthorization(Long authorizationId);

    public Authorization findOne(Long authorizationId);
    public List<Authorization> findAll();

    public Authorization findByAppUser(Long appId, Long userId);
}
