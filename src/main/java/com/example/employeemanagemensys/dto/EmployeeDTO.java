package com.example.employeemanagemensys.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDTO {
    private int id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String address;
}
