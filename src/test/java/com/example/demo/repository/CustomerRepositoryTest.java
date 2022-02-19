package com.example.demo.repository;

import com.example.demo.entity.Customer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    static int custId1, custId2;

    @BeforeAll
    static void  setUp(@Autowired CustomerRepository customerRepository) {
        Customer c1 = customerRepository.save(new Customer("a","b","c@a.dk"));
        custId1 = c1.getId();

        custId2 = customerRepository.save(new Customer("aa","bb","c1@a.dk")).getId();
    }

    @Test
    public void testAddCustomer(){
        Customer custNew = customerRepository.save(new Customer("xx","yy","xx@a.dk"));
        assertNotEquals(0,custNew.getId());
        assertEquals(3,customerRepository.count());
    }
    @Test
    public void testCount(){
        assertEquals(2,customerRepository.count());
    }

    @Test
    public void testFindById(){
        Customer cFound = customerRepository.findById(custId1).orElse(null);
        assertEquals("c@a.dk",cFound.getEmail());
    }

}