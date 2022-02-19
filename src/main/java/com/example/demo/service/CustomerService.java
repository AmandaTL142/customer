package com.example.demo.service;

import com.example.demo.dto.CustomerResponseDto;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //Denne metode bruges til at udvælge de af customers attributter, der skal vises i frontend, idet de er defineret
    // i CustomerResponseDto's constructor
    public CustomerResponseDto getCustomer(int id) throws Exception {
        Customer cust = customerRepository.findById(id).orElseThrow(()-> new Exception("Not Found"));
        return new CustomerResponseDto(cust);
    }

    public List<CustomerResponseDto> getCustomers(){
        List<Customer> customers = customerRepository.findAll();
        return CustomerResponseDto.getList(customers);
    }

    public CustomerResponseDto addCustomer(CustomerResponseDto body){
        Customer custNew = customerRepository.save(new Customer(body));
        return new CustomerResponseDto(custNew);
    }

    public void deleteCustomer(int id) throws Exception {
        if (!customerRepository.existsById(id)){
            throw new Exception("Not found");
        } else{
            customerRepository.deleteById(id);
        }
    }

}
