package com.codegeekgao.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;

import java.io.Serializable;

/**
 * 演员实体类
 *
 * @author DonnieGao
 * @version Id: Actor.java, v 0.1 2018/4/11 下午11:56 DonnieGao Exp $$
 */
@Data
@NodeEntity
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class Actor implements Serializable {
    private static final long serialVersionUID = -7225891088359256974L;
    private Long id;
    private String name;
    private int birthDay;
}
