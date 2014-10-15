package com.gift.registry.repository;

import com.gift.registry.domain.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long>{
    
}
