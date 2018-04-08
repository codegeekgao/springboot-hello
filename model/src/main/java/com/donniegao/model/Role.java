package com.donniegao.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色
 *
 * @author gaoxinpeng
 * @version Id: Role.java, v 0.1 2018/4/1 下午8:41 gaoxinpeng Exp $$
 */
@Data
public class Role implements Serializable {
    private Long id;
    private String name;
}
