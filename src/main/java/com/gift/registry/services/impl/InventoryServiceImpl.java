package com.gift.registry.services.impl;

import com.gift.registry.domain.Inventory;
import com.gift.registry.repository.InventoryRepository;
import com.gift.registry.services.InventoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Inventory find(Long id) {
        return inventoryRepository.findOne(id);
    }

    @Override
    public Inventory persist(Inventory entity) {
        return inventoryRepository.save(entity);
    }

    @Override
    public Inventory merge(Inventory entity) {
        if (entity.getId()!=null) {
            return inventoryRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Inventory entity) {
        inventoryRepository.delete(entity);
    }

    @Override
    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }
}