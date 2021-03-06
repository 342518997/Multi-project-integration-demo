package com.github.pengchong.dao;



import com.github.pengchong.entity.Resource;

import java.util.List;

/**
 * <p>Resource: peng chong
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface ResourceDao {

    public Resource createResource(Resource resource);
    public Resource updateResource(Resource resource);
    public void deleteResource(Long resourceId);

    Resource findOne(Long resourceId);
    List<Resource> findAll();

}
