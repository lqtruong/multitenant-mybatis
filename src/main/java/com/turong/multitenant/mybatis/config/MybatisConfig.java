package com.turong.multitenant.mybatis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.turong.multitenant.mybatis.mapper")
public class MybatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory
            (@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPlugins(new MultiSchemasInterceptor()); // multi-tenancy using different schemas
        return sessionFactory.getObject();
    }

}
