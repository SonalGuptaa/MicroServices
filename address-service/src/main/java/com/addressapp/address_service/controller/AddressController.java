package com.addressapp.address_service.controller;

import com.addressapp.address_service.dto.AddressDto;
import com.addressapp.address_service.service.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressServiceImpl addressService;

    @PostMapping
    ResponseEntity<AddressDto> saveInfo(@RequestBody AddressDto addressDto)
    {
        addressService.createAddress(addressDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<AddressDto>findAddressById(@PathVariable("employeeId") Integer id){

        AddressDto addressResponse = addressService.findAddressById(id);
        return new ResponseEntity<>(addressResponse, HttpStatus.OK);
    }


}
