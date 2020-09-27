package com.miniAPI.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String email;
    private String gender;
    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL )
    @JoinColumn(name = "customerID", referencedColumnName = "id")
    private List<Product> products;
}
