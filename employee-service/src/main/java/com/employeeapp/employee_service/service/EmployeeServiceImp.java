package com.employeeapp.employee_service.service;

import com.employeeapp.employee_service.dto.AddressDto;
import com.employeeapp.employee_service.entity.Employee;

import com.employeeapp.employee_service.repository.EmployeeRepository;
import com.employeeapp.employee_service.dto.EmployeeDto;
import com.employeeapp.employee_service.feignclient.AddressClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressClient addressClient;

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


        AddressDto addressDto = addressClient.getAddressByEmployeeId(id)
                .orElse(null);

        employeeDto.setAddressDto(addressDto);
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        List<EmployeeDto> employeeDtos =  employees.stream()
                        .map(employee -> modelMapper.map(employee,EmployeeDto.class))
                        .collect(Collectors.toList());

        employeeDtos.stream().forEach(employeeDto -> {
            employeeDto.setAddressDto(addressClient.getAddressByEmployeeId(employeeDto.getId())
                    .orElse(null));
        });

        return employeeDtos;

    }
}
