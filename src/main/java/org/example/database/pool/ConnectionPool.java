package org.example.database.pool;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("pool1")
@RequiredArgsConstructor
public class ConnectionPool {
    @Value("${db.username}")
    private final String userName;
    @Value("${db.pool.size}")
    private final Integer poolSize;

    @PostConstruct
    private void init() {
        System.out.println("@PostConstruct  --  Init-callback  --  Initializing connection pool "+userName);
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Destroying connection pool...");
    }
}
