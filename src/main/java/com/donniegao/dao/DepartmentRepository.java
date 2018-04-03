/**
 * Corearchi.com Inc.
 * Copyright (c) 2017-2018 All Rights Reserved.
 */
package com.donniegao.dao;

import com.donniegao.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 部门接口
 *
 * @author gaoxinpeng
 * @version Id: DepartmentRepository.java, v 0.1 2018/4/3 上午9:18 gaoxinpeng Exp $$
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}