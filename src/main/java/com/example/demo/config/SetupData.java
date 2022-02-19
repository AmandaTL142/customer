package com.example.demo.config;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class SetupData implements CommandLineRunner {

    CustomerRepository customerRepository;

    public SetupData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
      customerRepository.save(new Customer("Peter","Olsen","a@b.dk"));
      customerRepository.save(new Customer("Hanne","Olsen","a1@b.dk"));
      Customer c3 = new Customer("xx","yyy","a2@b.dk");
        System.out.println(c3.getId());
      customerRepository.save(c3);
        System.out.println(c3.getId());
    }
}
