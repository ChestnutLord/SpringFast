package org.example.repository;

import org.example.database.ConnectionPool;

public class CompanyRepository {

    private ConnectionPool connectionPool;

    private CompanyRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public static CompanyRepository companyRepositoryFactoryMethod(ConnectionPool connectionPool){
        return new CompanyRepository(connectionPool);
    }
}
