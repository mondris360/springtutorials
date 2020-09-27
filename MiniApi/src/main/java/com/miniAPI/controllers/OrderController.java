package com.miniAPI.controllers;

import com.miniAPI.dto.OrderRequest;
import com.miniAPI.dto.OrderResponse;
import com.miniAPI.entities.Customer;
import com.miniAPI.repository.CustomerRepository;
import com.miniAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    // auto inject both repositories
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/index")
    public String showHomePage(){
        return "index";
    }

    @PostMapping("/placeOrder")
    // method to place order
    public Customer placeOrder (@RequestBody OrderRequest requestBody){
        System.out.println("inside placeorder");
        Customer CustomerDetailsAndOrder =  requestBody.getCustomer();
        System.out.println("New Order"  +  CustomerDetailsAndOrder);
        // save customer order
       return customerRepository.save(CustomerDetailsAndOrder);
    }

    @GetMapping("/getOrders")
    // method to get all orders
    public List<Customer> getAllOrders () {
        return  customerRepository.findAll();
    }

    @GetMapping("/getOrderSummary")
    public List<OrderResponse> getOrderSummary(){
        return customerRepository.getOrders();
    }
}
