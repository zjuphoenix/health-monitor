package com.edu.zju.lab.health.monitor.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Administrator on 2015/10/14.
 */
@ConfigurationProperties(prefix = "bonecp.jdbc", locations = "classpath:conf/datasource.properties",ignoreUnknownFields = false)
public class DataSourceProperties {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private int idleConnectionTestPeriodInMinutes;
    private int idleMaxAgeInMinutes;
    private int maxConnectionsPerPartition;
    private int minConnectionsPerPartition;
    private int partitionCount;
    private int acquireIncrement;
    private int statementsCacheSize;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

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

    public int getIdleConnectionTestPeriodInMinutes() {
        return idleConnectionTestPeriodInMinutes;
    }

    public void setIdleConnectionTestPeriodInMinutes(int idleConnectionTestPeriodInMinutes) {
        this.idleConnectionTestPeriodInMinutes = idleConnectionTestPeriodInMinutes;
    }

    public int getIdleMaxAgeInMinutes() {
        return idleMaxAgeInMinutes;
    }

    public void setIdleMaxAgeInMinutes(int idleMaxAgeInMinutes) {
        this.idleMaxAgeInMinutes = idleMaxAgeInMinutes;
    }

    public int getMaxConnectionsPerPartition() {
        return maxConnectionsPerPartition;
    }

    public void setMaxConnectionsPerPartition(int maxConnectionsPerPartition) {
        this.maxConnectionsPerPartition = maxConnectionsPerPartition;
    }

    public int getMinConnectionsPerPartition() {
        return minConnectionsPerPartition;
    }

    public void setMinConnectionsPerPartition(int minConnectionsPerPartition) {
        this.minConnectionsPerPartition = minConnectionsPerPartition;
    }

    public int getPartitionCount() {
        return partitionCount;
    }

    public void setPartitionCount(int partitionCount) {
        this.partitionCount = partitionCount;
    }

    public int getAcquireIncrement() {
        return acquireIncrement;
    }

    public void setAcquireIncrement(int acquireIncrement) {
        this.acquireIncrement = acquireIncrement;
    }

    public int getStatementsCacheSize() {
        return statementsCacheSize;
    }

    public void setStatementsCacheSize(int statementsCacheSize) {
        this.statementsCacheSize = statementsCacheSize;
    }
}

