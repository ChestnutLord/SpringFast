package org.example;

import org.example.database.pool.ConnectionPool;
import org.example.database.repository.CompanyRepository;
import org.example.database.repository.CrudRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (var context = new ClassPathXmlApplicationContext("application.xml")) {

            var connectionPool = context.getBean("pool1", ConnectionPool.class);
            var companyRepository = context.getBean("companyRepository", CrudRepository.class);
            System.out.println(companyRepository.findById(1));
        }
    }
}