package com.tcs.exchangerate.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_tbl")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;

}
