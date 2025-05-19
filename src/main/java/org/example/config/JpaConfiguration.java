package org.example.config;

import jakarta.annotation.PostConstruct;
import org.example.config.condition.JpaCondition;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Conditional(JpaCondition.class)
@Configuration
public class JpaConfiguration {

//    @Bean
//    // название метода будет id бина
//    @ConfigurationProperties(prefix = "db")
//    public DatabaseProperties databaseProperties() {
//        return new DatabaseProperties();
//    }

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct: JpaCondition загружен, т.к. условие в JpaCondition выполнено");
    }
}
