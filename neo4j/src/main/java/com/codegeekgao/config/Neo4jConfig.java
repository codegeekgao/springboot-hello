package com.codegeekgao.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Neo4j配置类
 *
 * @author Denniegao
 * @version Id: Neo4jConfig.java, v 0.1 2018/4/12 下午10:53 Denniegao Exp $$
 */
@Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories(basePackages = "com.codegeekgao.dao")
public class Neo4jConfig extends Neo4jConfiguration {

    @Bean
    @Override
    public SessionFactory getSessionFactory() {
        return new SessionFactory("com.codegeekgao.model");
    }
}
