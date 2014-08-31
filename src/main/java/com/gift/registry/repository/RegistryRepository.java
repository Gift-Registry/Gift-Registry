package com.gift.registry.repository;

import com.gift.registry.domain.Registry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistryRepository extends JpaRepository<Registry, Long>{
    
}
