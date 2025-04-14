package org.example;

import org.example.database.ConnectionPool;
import org.example.repository.CompanyRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (var context = new ClassPathXmlApplicationContext("application.xml")) {

            var connectionPool = context.getBean("pool1", ConnectionPool.class);
            var companyRep = context.getBean("companyRepository", CompanyRepository.class);
            System.out.println(companyRep);

        }
    }
}