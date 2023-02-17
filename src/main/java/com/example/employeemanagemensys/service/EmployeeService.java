package com.example.employeemanagemensys.service;

import com.example.employeemanagemensys.dto.EmployeeDTO;
import com.example.employeemanagemensys.entity.Employee;
import com.example.employeemanagemensys.repo.EmployeeRepo;
import com.example.employeemanagemensys.util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public String UpdateEmp(EmployeeDTO empDto){
        if (repo.existsById(empDto.getId())){
            repo.save(modelMapper.map(empDto, Employee.class));
            return VarList.RSP_SUCCESS;
        }
        else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<EmployeeDTO> getAllEmployees(){
        if (repo.findAll().isEmpty()){
            return null;
        }
        else{
            List<Employee> employeeList = repo.findAll();
            return modelMapper.map(employeeList, new TypeToken<ArrayList<EmployeeDTO>>(){}.getType());
        }
    }

    public EmployeeDTO getEmpById(int id){
        if(repo.existsById(id)){
            Employee employee=repo.findById(id).orElse(null);
            return modelMapper.map(employee, EmployeeDTO.class);
        }else{
            return null;
        }
    }

    public String deleteEmp(int id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
