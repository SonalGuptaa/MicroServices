package com.employeeapp.employee_service.service;

import com.employeeapp.employee_service.dto.AddressDto;
import com.employeeapp.employee_service.entity.Employee;

import com.employeeapp.employee_service.repository.EmployeeRepository;
import com.employeeapp.employee_service.dto.EmployeeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeServiceImp implements EmployeeService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private WebClient webClient;

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
    //   AddressDto addressDto = new AddressDto();
       Employee employee = employeeRepository.findById(id).get();

       //converting JPA Employee Entitiy to EmployeeDto using ModelMapper
       EmployeeDto employeeDto = modelMapper.map(employee,EmployeeDto.class);

      //Calling Address Service using WebClient
        AddressDto addressDto = webClient
                                .get()
                                .uri("/addresses/"+id)
                                .retrieve()
                                .bodyToMono(AddressDto.class)
                                .block();

        employeeDto.setAddressDto(addressDto);
        return employeeDto;
    }
}
