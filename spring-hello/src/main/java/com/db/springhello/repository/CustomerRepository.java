package com.db.springhello.repository;

import com.db.springhello.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
@Component
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

//    @Query(value = "SELECT * FROM customers WHERE first_name = ?1",
//            countQuery = "SELECT count(*) FROM customers WHERE first_name = ?1",
//            nativeQuery = true)
    Page<Customer> findByFirstNameLike(String firstname, Pageable pageable);
}
