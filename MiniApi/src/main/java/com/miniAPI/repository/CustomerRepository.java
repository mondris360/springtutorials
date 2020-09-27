package com.miniAPI.repository;

import com.miniAPI.dto.OrderResponse;
import com.miniAPI.entities.Customer;
import org.hibernate.criterion.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

   @Query("SELECT new com.miniAPI.dto.OrderResponse(c.name, p.productName, p.price) FROM Customer c JOIN c.products as p")
   public List<OrderResponse> getOrders();
//    @Query("SELECT new com.miniAPI.dto.OrderResponse(c.name, p.productName, p.price) as c FROM Customer JOIN Customer.products as Product")

}
