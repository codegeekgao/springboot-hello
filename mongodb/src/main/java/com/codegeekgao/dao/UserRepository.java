package com.codegeekgao.dao;

import com.codegeekgao.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 用户接口测试
 *
 * @author DonnieGao
 * @version Id: UserRepository.java, v 0.1 2018/4/11 上午11:59 DonnieGao Exp $$
 */
public interface UserRepository extends MongoRepository<User, String> {
    /**
     * 通过用户名进行用户查询
     *
     * @param userName 用户名
     * @return 查询用户结果
     */
    User findByUserName(String userName);
}
