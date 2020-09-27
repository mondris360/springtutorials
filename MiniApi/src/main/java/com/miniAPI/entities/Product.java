package com.miniAPI.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue
    private long productID;
    private String productName;
    private int quantity;
    private int price;
}
