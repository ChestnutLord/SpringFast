package org.example.config;

import org.example.database.pool.ConnectionPool;
import org.example.database.repository.CompanyRepository;
import org.example.database.repository.CrudRepository;
import org.springframework.aop.target.CommonsPool2TargetSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Component;
import org.web.config.WebConfiguration;

@Import(WebConfiguration.class)
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "org.example",
        useDefaultFilters = false,
        includeFilters = {
                @Filter(type = FilterType.ANNOTATION, value = Component.class),
                @Filter(type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
                @Filter(type = FilterType.REGEX,pattern="com\\..+Repository")
        })
public class ApplicationConfiguration {

        @Bean("pool2")
        public ConnectionPool pool2(){
                return new ConnectionPool("test-name",20);
        }

        // Зависимость inject автоматически
        @Bean
        public CompanyRepository companyRepository2 (@Qualifier("pool2") ConnectionPool pool2){
                return new CompanyRepository(pool2);
        }

}
