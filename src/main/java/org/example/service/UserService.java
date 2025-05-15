package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.database.entity.Company;
import org.example.database.repository.CrudRepository;
import org.example.database.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // генерирует конструктор с полями у которых поля final
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> crudRepository;
}
