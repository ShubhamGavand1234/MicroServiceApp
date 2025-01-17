package com.example.address_Service.repository;

import com.example.address_Service.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDAO extends JpaRepository<Address, Integer> {
    public Address findByEmpId(int id);
}
