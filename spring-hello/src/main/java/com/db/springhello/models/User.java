package com.db.springhello.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    public int id;

    @Column(name = "uid")
    public String uid;

    public String username;
    public String password;
    public String email;

    public int role;

}
