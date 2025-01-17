package com.example.address_Service.controller;

import com.example.address_Service.dto.AddressDTO;
import com.example.address_Service.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/a")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/home")
    public ResponseEntity<String> home(){
        return new ResponseEntity<>("This is Address class", HttpStatus.OK);
    }

    @GetMapping("address/{addId}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable("addId") int id){

        AddressDTO address = addressService.getAddressById(id);
        return  new ResponseEntity<>(address, HttpStatus.OK);
    }

    @GetMapping("address/emp/{empId}")
    public ResponseEntity<AddressDTO> getAddressByEmpId(@PathVariable("empId") int id){

        AddressDTO address = addressService.getAddressByEmpId(id);
        return  new ResponseEntity<>(address, HttpStatus.OK);
    }
}
