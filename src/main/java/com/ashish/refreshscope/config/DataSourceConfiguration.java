package com.ashish.refreshscope.config;

import com.ashish.refreshscope.dto.DataSourceDto;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {
    @Bean
    @RefreshScope
    public DataSource dataSource(DataSourceDto dataSourceDto){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(dataSourceDto.getUrl());
        hikariDataSource.setPassword(dataSourceDto.getPassword());
        hikariDataSource.setUsername(dataSourceDto.getUsername());
        hikariDataSource.setDriverClassName(dataSourceDto.getDriverClassName());
        hikariDataSource.setConnectionTestQuery("select 1");
        hikariDataSource.setValidationTimeout(3000l);
        hikariDataSource.setIdleTimeout(10000l);
        hikariDataSource.setMaximumPoolSize(5);
        hikariDataSource.setMinimumIdle(0);
        return hikariDataSource;
    }

//    @Bean
//    public DataSourceInitializer dataSourceInitializer(DataSource dataSource){
//        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
//        dataSourceInitializer.setDataSource(dataSource);
//        dataSourceInitializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("data.sql")));
//        return dataSourceInitializer;
//    }
}
