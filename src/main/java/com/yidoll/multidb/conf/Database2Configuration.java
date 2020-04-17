package com.yidoll.multidb.conf;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

/**
 * @author: ydcai
 * @create: 2020-04-17 09:43
 **/
@Configuration
@MapperScan(basePackages = "com.yidoll.multidb.db2.dao", sqlSessionTemplateRef = "db2SqlSessionTemplate")
public class Database2Configuration {
    /**
     * 生成数据源.  @Primary 注解声明为默认数据源
     */
    @Bean(name = "db2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hikari.db2")
    public DataSource db1DataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     * 创建sqlsession
     * @return
     */
    @Bean(name = "db2SqlSessionFactory")
    public SqlSessionFactory db1SqlSession(@Qualifier("db2DataSource")DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSession =  new SqlSessionFactoryBean();
        sqlSession.setDataSource(dataSource);
        return sqlSession.getObject();
    }

    /**
     * 配置事务管理
     */
    @Bean(name = "db2TransactionManager")
    public TransactionManager db1TransactionManager(@Qualifier("db2DataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "db2SqlSessionTemplate")
    public SqlSessionTemplate db1SqlSessionTemplate(@Qualifier("db2SqlSessionFactory") SqlSessionFactory sqlSession){
        return new SqlSessionTemplate(sqlSession);
    }
}
