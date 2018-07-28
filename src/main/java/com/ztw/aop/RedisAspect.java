package com.ztw.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;


/**
 * @Describe
 * @Author https://www.jianshu.com/p/fa03da49c3a0
 * @Date 2018/7/7 13:42
 **/

@Component
@Aspect
public class RedisAspect {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 拦截所有元注解RedisCache注解的方法
     */
    @Pointcut("@annotation(com.ztw.annotation.RedisCache)")
    public void pointcutMethod() {

    }


    /**
     * 环绕处理，先从Redis里获取缓存,查询不到，就查询MySQL数据库，
     * 然后再保存到Redis缓存里
     *
     * @param joinPoint
     * @return
     */
    @Around("pointcutMethod()")
    public Object around(ProceedingJoinPoint joinPoint) {
        //前置：从Redis里获取缓存
        //先获取目标方法参数
        String applId = null;
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            applId = String.valueOf(args[0]);
        }

        //获取目标方法所在类
        String target = joinPoint.getTarget().toString();
        String className = target.split("@")[0];

        //获取目标方法的方法名称
        String methodName = joinPoint.getSignature().getName();

        //redis中key格式：    applId:方法名称
        String redisKey = applId + ":" + className + "." + methodName;

        Object obj = redisTemplate.opsForValue().get(redisKey);

        if (obj != null) {
//            LOGGER.info("**********从Redis中查到了数据**********");
//            LOGGER.info("Redis的KEY值:"+redisKey);
//            LOGGER.info("REDIS的VALUE值:"+obj.toString());
            return obj;
        }
//        LOGGER.info("Redis缓存AOP处理所用时间:"+(endTime-startTime));
//        LOGGER.info("**********没有从Redis查到数据**********");
        try {
            obj = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
//        LOGGER.info("**********开始从MySQL查询数据**********");
        //后置：将数据库查到的数据保存到Redis
        try {
            redisTemplate.opsForValue().set(redisKey, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }


}
