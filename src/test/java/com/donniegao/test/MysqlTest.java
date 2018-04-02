package com.donniegao.test;


import com.donniegao.configuration.JpaConfiguration;
import com.donniegao.dao.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试mysql连接
 *
 * @author gaoxinpeng
 * @version Id: MysqlTest.java, v 0.1 2018/4/2 下午11:22 gaoxinpeng Exp $$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfiguration.class})
@Slf4j
public class MysqlTest {

    @Autowired
    private UserRepository userRepository;
}
