package com.app.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String name;
    public String email;

    public Customer() {
    }

    public Customer(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
