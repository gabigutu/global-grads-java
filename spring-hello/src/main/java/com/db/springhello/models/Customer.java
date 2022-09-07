package com.db.springhello.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    public int id;

    @Column(columnDefinition = "varchar(50)", name="username", nullable = false)
    public String username;

    public String address;

    @Column(name="first_name", nullable = false)
    public String firstName;

}
