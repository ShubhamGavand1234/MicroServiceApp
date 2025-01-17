package com.example.Employee_Service.controller;

import com.example.Employee_Service.dto.EmployeeDTO;
import com.example.Employee_Service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/e")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;



    @GetMapping("/home")
    public ResponseEntity<String> home(){
        return new ResponseEntity<>("This is Employee class", HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") int id){
        EmployeeDTO emp = employeeService.getEmployee(id);
        return new ResponseEntity<>( emp, HttpStatus.OK);
    }

    @GetMapping("/employeewithaddress/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeWithAddress(@PathVariable("id") int id){

        EmployeeDTO employeeWithAddress = employeeService.getEmployeeWithAddress(id);

        return new ResponseEntity<>(employeeWithAddress, HttpStatus.OK);
    }
}
