package com.example.Employee_Service.feignpkg;

import com.example.Employee_Service.dto.AddressDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//http://localhost:8083/api/a/address/emp
@FeignClient(name = "address-service", url = "http://localhost:8083", path = "/api/a/address/emp")
//@FeignClient(name = "address-service", path = "/api/a/address/emp")// for ribbon
//@RibbonClient(name ="address-service")
public interface AddressFeignClient { //proxy class no need to implement

    @GetMapping("/{id}")
    AddressDTO getAddressByEmployeeId(@PathVariable("id") int id);

}
