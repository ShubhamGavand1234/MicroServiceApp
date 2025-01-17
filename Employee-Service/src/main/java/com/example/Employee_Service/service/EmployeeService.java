package com.example.Employee_Service.service;

import com.example.Employee_Service.dto.AddressDTO;
import com.example.Employee_Service.dto.EmployeeDTO;
import com.example.Employee_Service.entity.Employee;
import com.example.Employee_Service.feignpkg.AddressFeignClient;
import com.example.Employee_Service.repository.EmployeeDAO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private ModelMapper modelMapper;

    //@Autowired
    //private RestTemplate restTemplate;

//    @Autowired
//    public EmployeeService( @Value("${addressservice.base.url}") String addressBaseUrl,RestTemplateBuilder builder){
//       this.restTemplate =  builder
//               .rootUri(addressBaseUrl).build();
//    }

    @Autowired
    private WebClient webClient;

    @Autowired
    private AddressFeignClient addressFeignClient;

    public EmployeeDTO getEmployee(int id){
    Optional<Employee> employee = employeeDAO.findById(id);
    return  modelMapper.map(employee.get(), EmployeeDTO.class);
    }

//    @Value("${addressservice.base.url}")
//    private String addressBaseUrl;

    public EmployeeDTO getEmployeeWithAddress(int id){
//        String addressServiceUrl = "http://localhost:8083/api/a/address/emp/" + id; //with getForEntity
//        ResponseEntity<AddressDTO> addressResponse = restTemplate.getForEntity(addressServiceUrl, AddressDTO.class);
       // AddressDTO addressResponse = getEmpployeeWithAddresbyIdUsingRestTemplate(id); restTemplateCOde

        //WebClient Calls
//        AddressDTO addressResponse = webClient
//                .get()
//                .uri("/{id}", id)
//                .retrieve()
//                .bodyToMono(AddressDTO.class)
//                .block();

        //WebClient Call end
        //FeignClient method call
        AddressDTO addressResponse = addressFeignClient.getAddressByEmployeeId(id);
        //FeignClient method call ended
        Optional<EmployeeDTO> emp = Optional.ofNullable(getEmployee(id));
//        emp.get().setAddressDTO(addressResponse.getBody()); //with getForEntity
        emp.get().setAddressDTO(addressResponse);
        EmployeeDTO result = emp.get() ;
        return  result;
    }

    //for using restTemplate
//    public AddressDTO getEmpployeeWithAddresbyIdUsingRestTemplate(int id){
//            return  restTemplate.getForObject("/{id}", AddressDTO.class, id);
//    }

}
