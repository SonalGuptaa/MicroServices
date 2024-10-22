package com.addressapp.address_service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
public class AddressDto {
    private String city;
    private String state;
    private Integer pincode;
}
