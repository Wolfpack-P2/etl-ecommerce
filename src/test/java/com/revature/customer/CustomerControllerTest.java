package com.revature.customer;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerTest {

    @Autowired
    private CustomerController customerController;

    @Test
    public void testGetAllCustomers() {
        List<Customer> customers = customerController.getAllCustomers();
        for (Customer customer : customers) {
            assert customer.getCustomerName() != null;
            assert customer.getCity() != null;
            assert customer.getCountry() != null;
        }
    }
}
