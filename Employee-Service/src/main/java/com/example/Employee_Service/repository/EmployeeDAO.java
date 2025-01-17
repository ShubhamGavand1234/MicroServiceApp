package com.example.Employee_Service.repository;

import com.example.Employee_Service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}
