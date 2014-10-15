package com.gift.registry.repository;

import com.gift.registry.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{
    
}
