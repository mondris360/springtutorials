package com.springboot.lattest.demo.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="students")
public class Student {

    // for db  columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message="Name is compulsory")
    @Column(name = "name")
    private String name;

    @NotBlank(message ="Email is compulsory")
    @Column(name= "email", unique =  true)
    private String email;

    @Column(name = "address")
    private String Address;

    @NotBlank(message = "phone number is compulsory")
    @Column(name = "phoneNo")
    private String phoneNo;


    public Student(String name, String email, String phoneNo) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    // overloaded constructor
    public Student(){}


    // getters and setters


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", Address='" + Address + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
