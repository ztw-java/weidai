package com.ztw;


import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * EnableMethodCache 和 EnableCreateCacheAnnotation 是用于激活jetcache
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
