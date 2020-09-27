package com.mondris.customer.Repository;

import com.mondris.customer.Entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer getCustomerByEmail(String email);
    boolean existsByEmail(String Email);
}
