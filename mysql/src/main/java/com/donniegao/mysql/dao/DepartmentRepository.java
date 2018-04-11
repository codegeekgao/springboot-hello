package com.donniegao.mysql.dao;

import com.donniegao.mysql.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 部门接口
 *
 * @author DonnieGao
 * @version Id: DepartmentRepository.java, v 0.1 2018/4/3 上午9:18 DonnieGao Exp $$
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}