package com.addressapp.address_service.service;

import com.addressapp.address_service.dto.AddressDto;
import com.addressapp.address_service.entity.Address;
import com.addressapp.address_service.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements  AddressService {

    @Autowired
    private ModelMapper modelMapper;

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        Address address = modelMapper.map(addressDto,Address.class);
        Address saveAddress = addressRepository.save(address);
        AddressDto saveAddressDto = modelMapper.map(saveAddress,AddressDto.class);
        return saveAddressDto;
    }
    @Override
    public AddressDto findAddressById(Integer employeeId) {
        Optional<Address> address = addressRepository.findByEmployeeId(employeeId);
        if (address.isPresent()) {
            return modelMapper.map(address.get(), AddressDto.class);
        } else {
            throw new RuntimeException("Address not found for employee id: " + employeeId);
        }
    }

//    @Override
//    public AddressDto findAddressById(Integer employeeId) {
//        Address address = addressRepository.findAddressByEmployeeId(employeeId);
//
//        AddressDto addressDto = modelMapper.map(address,AddressDto.class);
//        return addressDto;
//    }

//    @Override
//    public AddressDto findAddressById(Integer employeeId) {
//        Address address = addressRepository.findById(addressId).get();
//        AddressDto addressDto =  modelMapper.map(address,AddressDto.class);
//       return addressDto;
//    }
}
