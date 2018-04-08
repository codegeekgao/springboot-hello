package com.codegeekgao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author gaoxinpeng
 * @version Id: RedisTest.java, v 0.1 2018/4/8 下午5:59 gaoxinpeng Exp $$
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void save() {

        redisTemplate.opsForValue().set("admin", "qqq");
        System.out.println(redisTemplate.opsForValue().get("admin"));
    }
}
