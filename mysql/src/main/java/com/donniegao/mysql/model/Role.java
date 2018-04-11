package com.donniegao.mysql.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 角色
 *
 * @author DonnieGao
 * @version Id: Role.java, v 0.1 2018/4/1 下午8:41 DonnieGao Exp $$
 */
@Entity
@Table(name = "role")
@Data
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
