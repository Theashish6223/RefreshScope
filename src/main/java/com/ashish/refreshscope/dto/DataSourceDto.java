package com.ashish.refreshscope.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration("dataSourceDto")
@ConfigurationProperties(prefix = "db")
public class DataSourceDto {
    private String username;
    private String password;
    private String url;
    private String driverClassName;
    private String connectionPoolSize;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getConnectionPoolSize() {
        return connectionPoolSize;
    }

    public void setConnectionPoolSize(String connectionPoolSize) {
        this.connectionPoolSize = connectionPoolSize;
    }
}
