package com.facebook2.com.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
public class User {


    public User(String firstName, String lastName, String email, String password, String gender,
                String DateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.DateOfBirth = DateOfBirth;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userID;

    @NotBlank(message = "First name is compulsory")
    private String firstName;

    @NotBlank(message = "lastName is Compulsory")
    private  String lastName;

    @NotBlank( message = "Email is compulsory")
    private String email;

    @NotBlank( message = "Password is compulsory")
    private  String password;

    @NotBlank( message = "gender is compulsory")
    private String gender;

    @NotBlank( message = "Date of Birth is compulsory")
    private String DateOfBirth;

    private Timestamp dateCreated  = new Timestamp(System.currentTimeMillis());
    private String status =  "active";



//    @OneToMany(targetEntity = Like.class, cascade = CascadeType.ALL)
//    @JoinColumn(name="userID", referencedColumnName = "userID")
//    List<Like> likes =  new ArrayList<>();

}
