package com.donniegao.redis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author gaoxinpeng
 * @version Id: UserRedis.java, v 0.1 2018/4/5 上午2:04 gaoxinpeng Exp $$
 */
@Repository
public class UserRedis {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void add() {

    }
}
