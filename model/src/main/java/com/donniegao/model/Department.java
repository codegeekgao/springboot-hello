package com.donniegao.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 部门实体类
 *
 * @author gaoxinpeng
 * @version Id: Department.java, v 0.1 2018/4/1 下午7:42 gaoxinpeng Exp $$
 */
@Data
public class Department implements Serializable {

    /**
     * ● SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
     * ● IDENTITY：主键由数据库自动生成（主要是自动增长型）
     * ● AUTO：主键由程序控制。
     */
    private Long id;
    private String name;

}
