package integration;

import org.example.database.pool.ConnectionPool;
import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.mock.mockito.SpyBean;

@TestConfiguration
public class TestApplicationRunner {

//    @SpyBean(name = "pool1")
    private ConnectionPool pool1;
}