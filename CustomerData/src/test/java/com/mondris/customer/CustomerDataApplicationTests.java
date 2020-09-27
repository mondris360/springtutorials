package com.mondris.customer;

import com.mondris.customer.Entities.Customer;
import com.mondris.customer.Repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class CustomerDataApplicationTests {
    @Autowired
    CustomerRepository customerRepository;
    Customer customer;


    @BeforeEach
    public void setup() {
        customer =  new Customer();
        customer.setName("Mondris");
        customer.setEmail("justmondris@gmail.com");
    }

    @AfterEach
    // deletes the customer's record after running each operation
    public void setupForAfterEach(){
        if (customerRepository.existsById(customer.getId())) {
            customerRepository.delete(customer);
            System.out.println("customer deleted");
        }

    }
    @Test
    void contextLoads() {
    }


    @Test
    // method to create a new customer
    void ShouldCreateCustomer(){
        // save the customer object created by the setup method
        System.out.println("////////////////" + customer);
        Customer createCustomer = customerRepository.save(customer);
        Assertions.assertNotNull(createCustomer);
        Assertions.assertEquals("Mondris", createCustomer.getName());
    }

    @Test
    // method to retrieve a customer from the db
    void shouldRetrieveUserRecord(){
         // save a customer to the database
        customerRepository.save(customer);
        // get the customer back from the db
        Optional<Customer> getCustomer =  customerRepository.findById(customer.getId());
        Customer customerRecord = null;
        if (getCustomer.isPresent()){
            customerRecord =  getCustomer.get();
        }

        Assertions.assertNotNull(customerRecord);
        Assertions.assertEquals("justmondris@gmail.com", customerRecord.getEmail());
    }


    @Test
    void shouldUpdateCustomerRecord(){
        // save the customer to the db
        customerRepository.save(customer);
        // get the customer from db
        Optional<Customer> getCustomerRecord = customerRepository.findById(customer.getId());
        // if a record is found
        Customer customerRecord =  null;
        if (getCustomerRecord.isPresent()){
             customerRecord =  getCustomerRecord.get();
        }

        // update the customer record
         customerRecord.setName("Micheal Mondris");
        // save the updated customer to the db
        customerRepository.save(customerRecord);
        // check if the customer record was actually updated

        Optional<Customer> getCustomerUpdatedRecord =  customerRepository.findById(customer.getId());
        Customer updatedCustomerRecord =  null;
        if (getCustomerUpdatedRecord.isPresent()){
            updatedCustomerRecord =  getCustomerRecord.get();
        }

        // check if the updated field was updated
        Assertions.assertNotNull(updatedCustomerRecord);
        Assertions.assertEquals("Micheal Mondris", updatedCustomerRecord.getName() );
    }


    @Test
    void shouldDeleteCustomerRecord(){
        // store  new customer object to the db
        customerRepository.save(customer);
        // get the customer from the db
        Customer getCustomerRecord =  customerRepository.getCustomerByEmail(customer.getEmail());
        // delete the user record if it exists
        if (getCustomerRecord != null) {
            // delete the customer record
            customerRepository.delete(customer);
        }

        // try to get the deleted customer
        boolean  customerDoesnotExist =  customerRepository.existsByEmail(customer.getEmail());

        Assertions.assertFalse(customerDoesnotExist);
    }
}

