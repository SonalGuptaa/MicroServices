package com.employeeapp.employee_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
    private Integer employeeId;
    private String city;
    private String state;
    private Integer pincode;
}
