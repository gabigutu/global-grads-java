package com.db.springhello.repository;

import com.db.springhello.models.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
@Component
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
