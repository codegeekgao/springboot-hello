package com.donniegao.redis.dao;

import com.donniegao.mysql.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author gaoxinpeng
 * @version Id: UserRedis.java, v 0.1 2018/4/5 上午2:04 gaoxinpeng Exp $$
 */
@Repository
public class UserRedis {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private Gson gson = new Gson();

    /**
     * 添加单个用户的方法
     *
     * @param key
     * @param time
     * @param user
     */
    public void add(String key, Long time, User user) {
        // set void set(K key, V value, long timeout, TimeUnit unit)  //
        redisTemplate.opsForValue().set(key, gson.toJson(user), time, TimeUnit.MINUTES);
    }

    /**
     * 批量添加用户
     *
     * @param key
     * @param time
     * @param users
     */
    public void addBitch(String key, Long time, List<User> users) {
        // set void set(K key, V value, long timeout, TimeUnit unit)  //
        redisTemplate.opsForValue().set(key, gson.toJson(users), time, TimeUnit.MINUTES);
    }

    /**
     * 获取用户方法
     *
     * @param key
     * @return
     */
    public User get(String key) {
        User user = null;
        String userJson = redisTemplate.opsForValue().get(key);
        if (!StringUtils.isEmpty(userJson)) {
            user = gson.fromJson(userJson, User.class);
        }
        return user;
    }

    /**
     * 获取批量用户
     *
     * @param key
     * @return
     */
    public List<User> getUserList(String key) {
        List<User> ts = null;
        String listJson = redisTemplate.opsForValue().get(key);
        if (!StringUtils.isEmpty(listJson)) {
            gson.fromJson(listJson, new TypeToken<List<User>>() {
            }.getType());
        }
        return ts;
    }

    /**
     * 删除用户
     *
     * @param key
     */
    public void delete(String key) {
        redisTemplate.opsForValue().getOperations().delete(key);
    }
}
