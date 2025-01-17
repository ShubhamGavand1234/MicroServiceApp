package com.example.address_Service.service;

import com.example.address_Service.dto.AddressDTO;
import com.example.address_Service.entity.Address;
import com.example.address_Service.repository.AddressDAO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressDAO addressDAO;

    @Autowired
    private ModelMapper modelMapper;

    public AddressDTO getAddressById(int id){
        Optional<Address> address = addressDAO.findById(id);
        if(address.isPresent()){
            return modelMapper.map(address, AddressDTO.class);
        }
        return  null;
    }

    public AddressDTO getAddressByEmpId(int id){
        Optional<Address> address = Optional.ofNullable(addressDAO.findByEmpId(id));
        if(address.isPresent()){
            return modelMapper.map(address, AddressDTO.class);
        }
        return  null;
    }
}
