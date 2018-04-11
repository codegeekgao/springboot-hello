package com.codegeekgao.mongodbtest;

import com.codegeekgao.dao.UserRepository;
import com.codegeekgao.model.User;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * mongodb的测试
 *
 * @author gaoxinpeng
 * @version Id: MongodbTest.java, v 0.1 2018/4/11 下午2:42 gaoxinpeng Exp $$
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
/*@FixMethodOrder*/
public class MongodbTest {

    @Autowired
    private Environment env;
    @Autowired
    private UserRepository userRepository;

    @Before
    public void init() {
        Set<String> roles = new HashSet<>();
        roles.add("manage");
        User user = new User("1", "user", "12345678", "name", "email@com.cn", new Date(), roles);
        userRepository.save(user);
    }

    @Test
    public void findAll() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findByName() {
        User user = userRepository.findByUserName("user");
        System.out.println(user);
    }

    @Test
    public void connect() {
        MongoClient mongoClient = new MongoClient(env.getProperty("mongo.host"), 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(env.getProperty("mongo.database"));
        System.out.println(mongoDatabase);
    }
}
