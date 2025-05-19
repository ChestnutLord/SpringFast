package org.example;

import org.example.config.DatabaseProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ApplicationRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationRunner.class, args);

        System.out.println("BeanDefinitionCount "+context.getBeanDefinitionCount());
        System.out.println(context.getBean(DatabaseProperties.class));
    }
}