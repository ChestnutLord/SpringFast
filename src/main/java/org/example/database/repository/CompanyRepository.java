package org.example.database.repository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.bpp.Auditing;
import org.example.bpp.Transaction;
import org.example.database.entity.Company;
import org.example.database.pool.ConnectionPool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("CR_From_class")
@Transaction
@Auditing
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class CompanyRepository implements CrudRepository<Integer, Company> {

    @Qualifier("pool2")
    private final ConnectionPool connectionPool;
//     private final List<ConnectionPool> pools;
//    @Value("${db.pool.size}")
//    private final Integer poolSize;

    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct  --  Init-callback  --  init company repository");
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
