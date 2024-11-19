package com.employeeapp.employee_service.controller;


import com.employeeapp.employee_service.entity.Employee;
import com.employeeapp.employee_service.dto.EmployeeDto;
import com.employeeapp.employee_service.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    ResponseEntity<EmployeeDto> saveInfo(@RequestBody EmployeeDto employeeDto)
    {
       employeeService.createEmployee(employeeDto);
       return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseEntity<EmployeeDto> getInfoById(@PathVariable("id") Integer id)
    {
        EmployeeDto employeeDto =  employeeService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeDto);
    }
}
