package com.addressapp.address_service.service;

import com.addressapp.address_service.dto.AddressDto;

import java.util.List;

public interface AddressService {
    AddressDto createAddress(AddressDto addressDto);
    AddressDto findAddressById(Integer employeeId);
    List<AddressDto> findAllAddress();
}
