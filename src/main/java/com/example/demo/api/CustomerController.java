package com.example.demo.api;

import com.example.demo.dto.CustomerResponseDto;
import com.example.demo.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    public List<CustomerResponseDto> getCustomers(){
        return customerService.getCustomers();
        //return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public CustomerResponseDto getCustomer(@PathVariable int id) throws Exception {
        return customerService.getCustomer(id);
        //return customerRepository.findById(id).orElseThrow(()->new Exception("Not Found"));
    }

    @PostMapping
    public CustomerResponseDto addCustomer(@RequestBody CustomerResponseDto body){
        return customerService.addCustomer(body);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id) throws Exception {
        customerService.deleteCustomer(id);
    }

}
