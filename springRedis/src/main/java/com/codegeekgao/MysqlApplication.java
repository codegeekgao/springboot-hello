package com.codegeekgao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoxinpeng
 * @version Id: MysqlApplication.java, v 0.1 2018/4/3 下午10:43 gaoxinpeng Exp $$
 */
@RestController
@SpringBootApplication
public class MysqlApplication {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping(value = "/")
    public String sayHello() {
        return "Spring Redis";
    }

    @RequestMapping(value = "/set")
    public String set() {
        redisTemplate.opsForValue().set("name", "admin");
        return "set Success!";
    }

    public static void main(String[] args) {
        SpringApplication.run(MysqlApplication.class, args);
    }
}
