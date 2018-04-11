package com.codegeekgao.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import java.io.Serializable;

/**
 * 角色实体类
 *
 * @author gaoxinpeng
 * @version Id: Role.java, v 0.1 2018/4/12 上午12:05 gaoxinpeng Exp $$
 */
@Data
@JsonIdentityInfo(generator = JSOGGenerator.class)
@RelationshipEntity(type = "ACTS_IN")
public class Role implements Serializable {
    private static final long serialVersionUID = 8660628624274795990L;
    @GraphId
    private Long id;
    private String role;
    @StartNode
    private Actor actor;
    @EndNode
    private Movie movie;

    public Role(Actor actor, Movie movie, String name) {
        this.actor = actor;
        this.movie = movie;
        this.role = name;
    }
}
