package com.ztw.service;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.ztw.entity.User;


/**
 * 注解说明文档： https://github.com/alibaba/jetcache/wiki/CreateCache_CN
 */
public interface UserService {


    /**
     * name         redis缓存中的key
     * expire       缓存有效期
     * cacheType    仅使用远程缓存，即redis缓存
     * @param userId
     * @return
     */
    @Cached(name = "UserService#getUserById", expire = 3600, cacheType = CacheType.REMOTE)
    User getUserById(long userId);

    String getName(long userId);

}
