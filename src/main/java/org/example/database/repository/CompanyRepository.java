package org.example.database.repository;

import org.example.bpp.MyAnnotationInjectBean;
import org.example.database.pool.ConnectionPool;

public class CompanyRepository {

    @MyAnnotationInjectBean
    private ConnectionPool connectionPool;
}
