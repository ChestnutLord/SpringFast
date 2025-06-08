package org.example.mapper;

import lombok.RequiredArgsConstructor;
import org.example.database.entity.User;
import org.example.dto.CompanyReadDto;
import org.example.dto.UserReadDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserReadMapper implements Mapper<User, UserReadDto> {

    private final CompanyReadMapper companyReadMapper;

    @Override
    public UserReadDto map(User user) {
        CompanyReadDto companyReadDto = Optional.ofNullable(user.getCompany())
                .map(companyReadMapper::map)
                .orElse(null);
        return new UserReadDto(
                user.getId(),
                user.getUsername(),
                user.getBirthDate(),
                user.getFirstname(),
                user.getLastname(),
                user.getRole(),
                companyReadDto
        );
    }
}
