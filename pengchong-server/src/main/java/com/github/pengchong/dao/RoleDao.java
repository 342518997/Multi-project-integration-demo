package com.github.pengchong.dao;



import com.github.pengchong.entity.Role;

import java.util.List;

/**
 * <p>User: peng chong
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface RoleDao {

    public Role createRole(Role role);
    public Role updateRole(Role role);
    public void deleteRole(Long roleId);

    public Role findOne(Long roleId);
    public List<Role> findAll();
}
