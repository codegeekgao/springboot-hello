package com.donniegao.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 角色
 *
 * @author gaoxinpeng
 * @version Id: Role.java, v 0.1 2018/4/1 下午8:41 gaoxinpeng Exp $$
 */
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Role() {

    }
}
