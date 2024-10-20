package com.employeeapp.employee_service.mapper;

import com.employeeapp.employee_service.dto.EmployeeDto;
import com.employeeapp.employee_service.entity.Employee;

public class EmployeeMapper {

    //Converting the Employee JPA Entity to EmployeeDto
    public static EmployeeDto mapToEmployeeDto(Employee employee)
    {
        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getBloodGroup()
        );
        return  employeeDto;
    }

    //Comvert EmployeeDto to Employee JPA Entity
    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getName(),
                employeeDto.getEmail(),
                employeeDto.getBloodGroup()
        );

        return employee;
    }
}
