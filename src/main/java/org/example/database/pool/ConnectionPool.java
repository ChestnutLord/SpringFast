package org.example.database.pool;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;

public class ConnectionPool {

    private String userName;

    private Integer poolSize;

    private List<Object> args;

    private Map<String, Object> properties;

    public ConnectionPool(){
    }

    public ConnectionPool(String userName, Integer poolSize, List<Object> args, Map<String, Object> properties) {
        this.userName = userName;
        this.poolSize = poolSize;
        this.args = args;
        this.properties = properties;
    }

    public void setProperties(Map<String,Object> properties) {
        this.properties.putAll(properties);
    }

    @PostConstruct
    private void init() {
        System.out.println("Initializing connection pool...");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Destroying connection pool...");
    }
}
