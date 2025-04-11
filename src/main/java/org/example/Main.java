package org.example;

import org.example.database.ConnectionPool;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("application.xml");
        var connectionPool = context.getBean("pool1", ConnectionPool.class);
        System.out.println(connectionPool);
    }
}