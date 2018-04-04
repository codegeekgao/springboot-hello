package com.donniegao;

import com.donniegao.mysql.dao.DepartmentRepository;
import com.donniegao.mysql.dao.RoleRepository;
import com.donniegao.mysql.dao.UserRepository;
import com.donniegao.mysql.model.Department;
import com.donniegao.mysql.model.Role;
import com.donniegao.mysql.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;


/**
 * 测试mysql连接
 *
 * @author gaoxinpeng
 * @version Id: MysqlTest.java, v 0.1 2018/4/2 下午11:22 gaoxinpeng Exp $$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfig.class})
@Slf4j
public class MysqlTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Before
    public void initData() {
        userRepository.deleteAll();
        roleRepository.deleteAll();
        departmentRepository.deleteAll();
        log.info("删除所有department");

        Department department = new Department();
        department.setName("事业");
        log.info("保存department：{}", department);
        departmentRepository.save(department);
        Assert.notNull(department.getId());

        Role role = new Role();
        role.setName("admin");
        roleRepository.save(role);
        log.info("role：{}", role);
        Assert.notNull(role.getId());

        User user = new User();
        user.setName("user");
        user.setCreateDate(new Date());
        userRepository.save(user);
        log.info("user：{}", user);
        user.setDepartment(department);

        List<Role> roles = roleRepository.findAll();
        Assert.notNull(roles);
        user.setRoles(roles);
        userRepository.save(user);
        Assert.notNull(user.getId());
    }

    @Test
    public void findPage() {
        Pageable pageable = new PageRequest(0, 10, new Sort(Sort.Direction.ASC, "id"));
        Page<User> page = userRepository.findAll(pageable);
        Assert.notNull(page);
        for (User user : page.getContent()) {
            log.info("====user==== user name:{}, department name:{}, role name:{}",
                    user.getName(), user.getDepartment().getName(), user.getRoles().get(0).getName());
        }
    }

    //@Test
    public void test() {
        User user1 = userRepository.findByNameLike("u%");
        Assert.notNull(user1);

        User user2 = userRepository.readByName("user");
        Assert.notNull(user2);

        List<User> users = userRepository.getByCreateDateLessThan(new Date());
        Assert.notNull(users);
    }
}
