package com.gift.registry.repository;

import com.gift.registry.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
}
