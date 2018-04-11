package com.codegeekgao.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 电影实体类
 *
 * @author gaoxinpeng
 * @version Id: Movie.java, v 0.1 2018/4/12 上午12:02 gaoxinpeng Exp $$
 */
@Data
@JsonIdentityInfo(generator = JSOGGenerator.class) // 解决json序列化的循环饮用
@NodeEntity
public class Movie implements Serializable {
    private static final long serialVersionUID = 7121224233459136955L;
    @GraphId
    private Long id;
    private String title;
    private String year;
    @Relationship(type = "ACTS_IN", direction = Relationship.DIRECTION)
    List<Role> roles = new ArrayList<>();

    public Role addRole(Actor actor, String name) {
        Role role = new Role(actor, this, name);
        this.roles.add(role);
        return role;
    }
}
