package com.ztw.service;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.ztw.annotation.RedisCache;
import com.ztw.annotation.RedisCacheKey;
import com.ztw.dao.UserDao;
import com.ztw.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(long userId) {
        log.info("{} | 进入service方法", userId);
        return userDao.getUserById(userId);
    }


    @Cached(name = "UserService#getName", expire = 3600, cacheType = CacheType.REMOTE)
    @Override
    public String getName(long userId) {
        log.info("{} | 进入service方法", userId);
        return userDao.getName(userId);
    }


    @RedisCache
    public String getUserName(@RedisCacheKey String userName){
        System.out.println("1111111111111111");
        return "userName".concat(userName);
    }

}
