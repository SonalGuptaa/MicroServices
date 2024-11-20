package com.employeeapp.employee_service.feignclient;

import com.employeeapp.employee_service.dto.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name= "abc", url = "http://localhost:8080/")
public interface AddressClient {

    @GetMapping("/addresses/{id}")
    Optional<AddressDto> getAddressByEmployeeId(@PathVariable("id") int id);

}
