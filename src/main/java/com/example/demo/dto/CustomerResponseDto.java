package com.example.demo.dto;

import com.example.demo.entity.Customer;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
@NoArgsConstructor //Denne laver en tom constructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerResponseDto {
    int id;
    String firstName;
    String lastName;
    String email;
    String secret1;


    public CustomerResponseDto(Customer c) {
        this.id = c.getId();
        this.firstName = c.getFirstName();
        this.lastName = c.getLastName();
        this.email = c.getEmail();
    }

    public static List<CustomerResponseDto> getList(List<Customer> customerEntities){
        /* Denne metode kender vi, den, der bruges, er mere avanceret, men mere simpel i sit udtryk.
        List<CustomerResponseDto> all = new ArrayList<>();
        for(Customer c: customerEntities){
            all.add(new CustomerResponseDto(c));
        }
        return all;

         */

        //return customerEntities.stream().map(c->new CustomerResponseDto(c)).collect(Collectors.toList());

        //Nedenstående er JAVA's forslag til et forsimplet udtryk
        return customerEntities.stream().map(CustomerResponseDto::new).collect(Collectors.toList());
    }
}
