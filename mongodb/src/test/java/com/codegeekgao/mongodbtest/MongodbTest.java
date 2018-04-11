package com.codegeekgao.mongodbtest;

import com.codegeekgao.dao.UserRepository;
import com.codegeekgao.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

  /*  @Test
    public void connect() {
        Mongo mg = new Mongo("10.211.55.12",27017);
        DB db = mg.getDB("test");
       *//* for(String s:db.getCollectionNames()){
            System.out.println(s);
        }*//*

        Set<String> colls = db.getCollectionNames();
        for (String s : colls) {
            System.out.println(s);
        }
    }*/
}
