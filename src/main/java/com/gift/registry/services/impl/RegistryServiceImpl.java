package com.gift.registry.services.impl;

import com.gift.registry.domain.Registry;
import com.gift.registry.repository.RegistryRepository;
import com.gift.registry.services.RegistryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistryServiceImpl implements RegistryService{
    @Autowired
    private RegistryRepository registryRepository;
            
    @Override
    public Registry find(Long id) {
       return registryRepository.findOne(id);
    }

    @Override
    public Registry persist(Registry entity) {
        return registryRepository.save(entity);
    }

    @Override
    public Registry merge(Registry entity) {
        if (entity.getId()!=null) {
            return registryRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Registry entity) {
        registryRepository.delete(entity);
    }

    @Override
    public List<Registry> findAll() {
        return registryRepository.findAll();
    } 
}

