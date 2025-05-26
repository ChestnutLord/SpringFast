package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.database.repository.CompanyRepository;
import org.example.dto.CompanyReadDto;
import org.example.listener.entity.AccessType;
import org.example.listener.entity.EntityEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyService {

    private final CompanyRepository CR_From_class;
    private final UserService userService;
    private final ApplicationEventPublisher applicationEventPublisher;

//    public CompanyService(@Qualifier("CR_From_class") CrudRepository<Integer, Company> CR_From_class,
//                          UserService userService,
//                          ApplicationEventPublisher applicationEventPublisher) {
//        this.CR_From_class = CR_From_class;
//        this.userService = userService;
//        this.applicationEventPublisher = applicationEventPublisher;
//    }

    @Transactional
    public Optional<CompanyReadDto> findById(Integer id) {
        return CR_From_class.findById(id)
                .map(entity -> {
                    applicationEventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                    return new CompanyReadDto(entity.getId());
                });
    }
}
