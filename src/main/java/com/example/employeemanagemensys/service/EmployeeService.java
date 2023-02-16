package com.example.employeemanagemensys.service;

import com.example.employeemanagemensys.dto.EmployeeDTO;
import com.example.employeemanagemensys.entity.Employee;
import com.example.employeemanagemensys.repo.EmployeeRepo;
import com.example.employeemanagemensys.util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmployeeService {

    //@Autowired is used to inject the object dependency implicitly.
    @Autowired
    private EmployeeRepo repo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveEmp(EmployeeDTO empDto){
        if (repo.existsById(empDto.getId())){
            return VarList.RSP_DUPLICATED;
        }
        else{
            repo.save(modelMapper.map(empDto, Employee.class));
            //public <D> D map(Object source, Class<D> destinationType)
            return VarList.RSP_SUCCESS;
        }
    }
}
