package com.db.springhello.models;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    private int id;

}
