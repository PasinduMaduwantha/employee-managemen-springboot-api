package com.example.employeemanagemensys;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeManagemenSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagemenSysApplication.class, args);
    }

    /**
    * ModelMapper is a Java library that automates the mapping between Java beans
    * @Bean
    * applied on a method to specify that it returns a bean to be managed by Spring context. Spring Bean annotation is usually declared in Configuration classes methods. This annotation is also a part of the spring core framework
     */
    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
