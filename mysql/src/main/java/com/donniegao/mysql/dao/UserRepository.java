package com.donniegao.mysql.dao;


import com.donniegao.mysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 用户接口
 *
 * @author gaoxinpeng
 * @version Id: UserRepository.java, v 0.1 2018/4/1 下午8:59 gaoxinpeng Exp $$
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByNameLike(String name);

    User readByName(String name);

    List<User> getByCreateDateLessThan(Date star);
}
