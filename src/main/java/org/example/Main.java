package org.example;

import org.example.config.ApplicationConfiguration;
import org.example.database.pool.ConnectionPool;
import org.example.database.repository.CompanyRepository;
import org.example.database.repository.CrudRepository;
import org.example.service.CompanyService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {

            var connectionPool = context.getBean("pool1", ConnectionPool.class);
            var companyService = context.getBean(CompanyService.class);
            System.out.println(companyService.findById(1));
        }
    }
}