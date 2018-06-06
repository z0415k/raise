package com.black.kun.raise.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 数据源配置文件
 * @author zk
 */
@Configuration
@MapperScan(basePackages = "com.black.kun.raise.mapper", sqlSessionTemplateRef = "raiseSqlSessionTemplate")
public class DataSourceConfig {

    @Bean(name = "raiseDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.raise")
    public DataSource raiseDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "raiseSqlSessionFactory")
    public SqlSessionFactory raiseSqlSessionFactory(@Qualifier("raiseDataSource") DataSource dataSource) throws Exception {
        //使用mybatis-plus
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/**/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "raiseSqlSessionTemplate")
    public SqlSessionTemplate raiseSqlSessionTemplate(@Qualifier("raiseSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "test1TransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("raiseDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * mbp分页
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return  new PaginationInterceptor();
    }
}
