package org.example.database.repository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.example.bpp.Auditing;
import org.example.bpp.MyAnnotationInjectBean;
import org.example.bpp.Transaction;
import org.example.database.entity.Company;
import org.example.database.pool.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Optional;

@Transaction
@Auditing
public class CompanyRepository implements CrudRepository<Integer, Company>{

    @Value("${db.pool.size}")
    private Integer poolSize;

    @Autowired
    private ConnectionPool pool2;

    @Autowired
    List<ConnectionPool> connectionPoolList;

    @PostConstruct
    public void init() {
        System.out.println("init company repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById method...");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("delete method...");
    }
}
