package com.miniAPI.dto;

import com.miniAPI.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.repository.cdi.Eager;

@AllArgsConstructor
@NoArgsConstructor
@Eager
@Data
@ToString
public class OrderRequest {
    private Customer customer;
}
