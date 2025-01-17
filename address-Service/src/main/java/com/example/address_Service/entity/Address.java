package com.example.address_Service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private int address_id;

    @Column(name = "emp_id", nullable = false)
    private int empId;

    @Column(name = "localaddress", nullable = false, length = 255)
    private String localaddress;

    // Constructors
    public Address() {
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getEmp_id() {
        return empId;
    }

    public void setEmp_id(int emp_id) {
        this.empId = emp_id;
    }

    public String getLocaladdress() {
        return localaddress;
    }

    public void setLocaladdress(String localaddress) {
        this.localaddress = localaddress;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address_id=" + address_id +
                ", emp_id=" + empId +
                ", localaddress='" + localaddress + '\'' +
                '}';
    }
}
