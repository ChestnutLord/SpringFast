package org.example.config;

import jakarta.annotation.PostConstruct;
import org.example.config.condition.JpaCondition;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Conditional(JpaCondition.class)
@Configuration
public class JpaConfiguration {

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct: JpaCondition загружен, т.к. условие в JpaCondition выполнено");
    }
}
