package com.addressapp.address_service.service;

import com.addressapp.address_service.dto.AddressDto;

public interface AddressService {
  //  AddressDto createAddress(AddressDto addressDto);
    AddressDto findAddressById(Integer employeeId);
}
