package com.donniegao.mysql.config;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * JPA配置类
 *
 * @author DonnieGao
 * @version Id: JpaConfiguration.java, v 0.1 2018/4/2 下午10:54 DonnieGao Exp $$
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(basePackages = "com.donniegao.**.dao")
@EntityScan(basePackages = "com.donniegao.**.model")
public class JpaConfiguration {
    /**
     * 和HibernateTemplate一样，JpaTemplate也会将异常翻译为Spring的数据访问异常，
     * 而如果改成entityManagerFactory之后，异常就会变成Java SE的异常，比如非法参数，
     * 非法状态等异常。若要继续使用Spring的异常体系，那么要为JPA的DAO实现类加上@Repository注解，
     * 然后注册PersistenceExceptionTranslationPostProcessor实例。
     */
    @Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
