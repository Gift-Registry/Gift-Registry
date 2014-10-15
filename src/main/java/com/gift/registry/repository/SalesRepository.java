package com.gift.registry.repository;

import com.gift.registry.domain.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales, Long>{
    
}
