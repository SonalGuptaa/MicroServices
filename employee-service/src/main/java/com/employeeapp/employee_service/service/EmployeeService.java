package com.employeeapp.employee_service.service;

import com.employeeapp.employee_service.entity.Employee;
import com.employeeapp.employee_service.dto.EmployeeDto;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Integer id);
    List<EmployeeDto> getAllEmployees();
}
