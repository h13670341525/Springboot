package com.dhu.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.dhu.dao")
public class DataSourceConfig {

     @Bean
     @ConfigurationProperties(prefix = "mysql.datasource")
     public DataSource getDataSource(){
         return  DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
     }
}
