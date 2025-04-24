package org.example.database.pool;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("pool1")
public class ConnectionPool {
    private final String userName;
    private final Integer poolSize;


    @Autowired //можем не ставить, автоматически будет вызван
    public ConnectionPool(@Value("${db.username}") String userName, @Value("${db.pool.size}") Integer poolSize) {
        this.userName = userName;
        this.poolSize = poolSize;
    }

    @PostConstruct
    private void init() {
        System.out.println("@PostConstruct  --  Init-callback  --  Initializing connection pool "+userName);
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Destroying connection pool...");
    }
}
