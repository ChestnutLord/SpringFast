package org.example.repository;

import org.example.bpp.MyAnnotationInjectBean;
import org.example.database.ConnectionPool;

public class CompanyRepository {

    @MyAnnotationInjectBean
    private ConnectionPool connectionPool;
}
