package com.addressapp.address_service.repository;

import com.addressapp.address_service.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends JpaRepository<Address,Integer> {


    @Query(nativeQuery = true, value = "SELECT ea.id, ea.city,ea.state,ea.pincode FROM employeeDB.address ea join employeeDB.employees e on e.id = ea.employee_id where ea.employee_id=:employeeId;")
    Address findAddressByEmployeeId(@Param("employeeId") Integer employeeId);
}
