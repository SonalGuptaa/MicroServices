package com.addressapp.address_service.service;

import com.addressapp.address_service.dto.AddressDto;
import com.addressapp.address_service.entity.Address;
import com.addressapp.address_service.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements  AddressService {

    @Autowired
    private ModelMapper modelMapper;

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


//    @Override
//    public AddressDto createAddress(AddressDto addressDto) {
//      return null;
//    }

    @Override
    public AddressDto findAddressById(Integer employeeId) {
        Address address = addressRepository.findAddressByEmployeeId(employeeId);

        AddressDto addressDto = modelMapper.map(address,AddressDto.class);
        return addressDto;
    }

//    @Override
//    public AddressDto findAddressById(Integer employeeId) {
//        Address address = addressRepository.findById(addressId).get();
//        AddressDto addressDto =  modelMapper.map(address,AddressDto.class);
//       return addressDto;
//    }
}
