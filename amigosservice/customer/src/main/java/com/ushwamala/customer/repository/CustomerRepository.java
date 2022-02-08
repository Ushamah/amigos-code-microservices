package com.ushwamala.customer.repository;

import com.ushwamala.customer.model.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<customer, Integer> {
}
