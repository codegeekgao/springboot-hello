package com.donniegao.mysql.dao;

import com.donniegao.mysql.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 角色接口
 *
 * @author DonnieGao
 * @version Id: RoleRepository.java, v 0.1 2018/4/3 上午9:19 DonnieGao Exp $$
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
