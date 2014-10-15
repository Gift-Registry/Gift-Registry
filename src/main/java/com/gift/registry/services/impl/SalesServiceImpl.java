package com.gift.registry.services.impl;

import com.gift.registry.domain.Sales;
import com.gift.registry.repository.SalesRepository;
import com.gift.registry.services.SalesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesServiceImpl implements SalesService {
    @Autowired
    private SalesRepository salesRepository;

    @Override
    public Sales find(Long id) {
        return salesRepository.findOne(id);
    }

    @Override
    public Sales persist(Sales entity) {
        return salesRepository.save(entity);
    }

    @Override
    public Sales merge(Sales entity) {
                   if (entity.getId()!=null) {
            return salesRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Sales entity) {
        salesRepository.delete(entity);
    }

    @Override
    public List<Sales> findAll() {
        return salesRepository.findAll();
    }

 
}
