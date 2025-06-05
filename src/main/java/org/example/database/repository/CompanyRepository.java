package org.example.database.repository;

import org.example.database.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

     Optional<Company> findById(Integer id);

     void delete(Company entity);
}