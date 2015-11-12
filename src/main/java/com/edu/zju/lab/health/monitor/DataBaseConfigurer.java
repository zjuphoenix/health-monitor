package com.edu.zju.lab.health.monitor;

import com.edu.zju.lab.health.monitor.config.DataSourceProperties;
import com.jolbox.bonecp.BoneCPDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2015/9/20.
 */
@Configuration
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class )
@EnableConfigurationProperties(DataSourceProperties.class)
@EnableTransactionManagement
/*@MapperScan("com.edu.zju.lab.health.monitor.dao")*/
public class DataBaseConfigurer {
    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Bean(destroyMethod="close")
    public DataSource dataSource() {
        BoneCPDataSource boneCPDataSource = new BoneCPDataSource();
        boneCPDataSource.setDriverClass(dataSourceProperties.getDriverClassName());
        boneCPDataSource.setJdbcUrl(dataSourceProperties.getUrl());
        boneCPDataSource.setUsername(dataSourceProperties.getUsername());
        boneCPDataSource.setPassword(dataSourceProperties.getPassword());
        boneCPDataSource.setIdleConnectionTestPeriodInMinutes(dataSourceProperties.getIdleConnectionTestPeriodInMinutes());
        boneCPDataSource.setIdleMaxAgeInMinutes(dataSourceProperties.getIdleMaxAgeInMinutes());
        boneCPDataSource.setMaxConnectionsPerPartition(dataSourceProperties.getMaxConnectionsPerPartition());
        boneCPDataSource.setMinConnectionsPerPartition(dataSourceProperties.getMinConnectionsPerPartition());
        boneCPDataSource.setPartitionCount(dataSourceProperties.getPartitionCount());
        boneCPDataSource.setAcquireIncrement(dataSourceProperties.getAcquireIncrement());
        boneCPDataSource.setStatementsCacheSize(dataSourceProperties.getStatementsCacheSize());
        return boneCPDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        /*PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/orm/*.xml"));*/
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}

