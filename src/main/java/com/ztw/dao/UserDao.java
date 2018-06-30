package com.ztw.dao;


import com.ztw.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class UserDao {

    public User getUserById(long userId) {
        log.info("{} | 开始查询数据库", userId);
        User user = new User();
        user.setUserId(userId);
        user.setName("ztw");
        user.setGender(0);
        return user;
    }

    public String getName(long userId){
        log.info("{} | 进入dao层", userId);
        return "周杰伦".concat(String.valueOf(userId));
    }

}
