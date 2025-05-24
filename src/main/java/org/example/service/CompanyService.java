package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.database.entity.Company;
import org.example.database.repository.CrudRepository;
import org.example.dto.CompanyReadDto;
import org.example.listener.entity.AccessType;
import org.example.listener.entity.EntityEvent;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CrudRepository<Integer, Company> CR_From_class;
    private final UserService userService;
    private final ApplicationEventPublisher applicationEventPublisher;

//    public CompanyService(@Qualifier("CR_From_class") CrudRepository<Integer, Company> CR_From_class,
//                          UserService userService,
//                          ApplicationEventPublisher applicationEventPublisher) {
//        this.CR_From_class = CR_From_class;
//        this.userService = userService;
//        this.applicationEventPublisher = applicationEventPublisher;
//    }

    public Optional<CompanyReadDto> findById(Integer id) {
        return CR_From_class.findById(id)
                .map(entity -> {
                    applicationEventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                    return new CompanyReadDto(entity.getId());
                });
    }
}
