package com.addressapp.address_service.service;

import com.addressapp.address_service.dto.AddressDto;
import com.addressapp.address_service.entity.Address;
import com.addressapp.address_service.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.util.List;
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
            return null;
        }
    }

    @Override
    public List<AddressDto> findAllAddress() {
        List<Address> addresses = addressRepository.findAll();

        return addresses.stream()
                .map(address -> modelMapper.map(address, AddressDto.class))
                .collect(Collectors.toList());
    }
}
