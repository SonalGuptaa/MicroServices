package com.employeeapp.employee_service.service;

import com.employeeapp.employee_service.entity.Employee;
import com.employeeapp.employee_service.mapper.EmployeeMapper;
import com.employeeapp.employee_service.repository.EmployeeRepository;
import com.employeeapp.employee_service.dto.EmployeeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService{


    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        //Converting the EmployeeDto to JPA Entity
//         Employee employee = new Employee(
//                 employeeDto.getId(),
//                 employeeDto.getName(),
//                 employeeDto.getEmail(),
//                 employeeDto.getBloodGroup()
//         );
         Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
         Employee savedEmployee = employeeRepository.save(employee);

         //In controller returning EmployeeDto so need to convert JPA Entity
//        EmployeeDto saveEmployeeDto = new EmployeeDto(
//                savedEmployee.getId(),
//                savedEmployee.getName(),
//                savedEmployee.getEmail(),
//                savedEmployee.getBloodGroup()
//        );
        EmployeeDto saveEmployeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        return saveEmployeeDto;
    }


    @Override
    public EmployeeDto getEmployeeById(Integer id) {
       Employee employee = employeeRepository.findById(id).get();

       //converting JPA Employee Entitiy to EmployeeDto
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setBloodGroup(employee.getBloodGroup());

      // return employee;
        return employeeDto;


    }
}
