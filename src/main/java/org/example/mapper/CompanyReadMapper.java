package org.example.mapper;

import org.example.database.entity.Company;
import org.example.dto.CompanyReadDto;
import org.springframework.stereotype.Component;

@Component
public class CompanyReadMapper implements Mapper<Company, CompanyReadDto> {

    @Override
    public CompanyReadDto map(Company company) {
        return new CompanyReadDto(company.getId(),
                company.getName());
    }
}
