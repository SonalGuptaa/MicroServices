package com.employeeapp.employee_service.service;

import com.employeeapp.employee_service.entity.Employee;

import com.employeeapp.employee_service.repository.EmployeeRepository;
import com.employeeapp.employee_service.dto.EmployeeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService{

    @Autowired
    private ModelMapper modelMapper;
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        //Converting the EmployeeDto to JPA Entity
        Employee employee = modelMapper.map(employeeDto,Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);

         //In controller returning EmployeeDto so need to convert JPA Entity
        EmployeeDto saveEmployeeDto = modelMapper.map(savedEmployee,EmployeeDto.class);
        return saveEmployeeDto;
    }


    @Override
    public EmployeeDto getEmployeeById(Integer id) {
       Employee employee = employeeRepository.findById(id).get();

       //converting JPA Employee Entitiy to EmployeeDto using ModelMapper
       EmployeeDto employeeDto = modelMapper.map(employee,EmployeeDto.class);

        return employeeDto;


    }
}
