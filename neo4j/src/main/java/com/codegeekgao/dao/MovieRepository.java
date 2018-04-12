package com.codegeekgao.dao;

import com.codegeekgao.model.Movie;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 电影接口实现类
 *
 * @author gaoxinpeng
 * @version Id: MovieRepository.java, v 0.1 2018/4/12 下午10:57 gaoxinpeng Exp $$
 */
@Repository
public interface MovieRepository extends GraphRepository<Movie> {

    /**
     * 根据标题进行查询
     *
     * @param title
     * @return
     */
    Movie findByTitle(@Param("title") String title);
}
