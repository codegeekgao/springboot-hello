package com.codegeekgao.dao;

import com.codegeekgao.model.Actor;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * 演员接口
 *
 * @author gaoxinpeng
 * @version Id: ActorRepository.java, v 0.1 2018/4/12 下午11:06 gaoxinpeng Exp $$
 */
@Repository
public interface ActorRepository extends GraphRepository<Actor> {

}
