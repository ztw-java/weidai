package com.ztw;


import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * EnableMethodCache，EnableCreateCacheAnnotation这两个注解分别激活Cached和CreateCache注解
 *
 * 首先加入对cache的注解支持---@EnableMethodCache(basePackages="com.xx")
 * 后面的包名是使用该注解的方法所在的包的全路径
 *
 * JetCache中提供了@createCache的注解的支持，可以自己定义的cache，灵活性比较高，下面讲一下具体的用法
 * 加入createCache的支持----@EnableCreateCacheAnnotation
 *
 */
@EnableMethodCache(basePackages = "com.ztw")
@EnableCreateCacheAnnotation
@SpringBootApplication
public class AppStart {

    public static void main(String[] args) {
        SpringApplication.run(AppStart.class, args);
    }

}
