package com.donniegao.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户实体
 *
 * @author gaoxinpeng
 * @version Id: User.java, v 0.1 2018/4/1 下午8:09 gaoxinpeng Exp $$
 */

@Data
public class User implements Serializable {
    private Long id;
    private String name;
    private Date createDate;
    private Department department;
    private List<Role> roles;
}
