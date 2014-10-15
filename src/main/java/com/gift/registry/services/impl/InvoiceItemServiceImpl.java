package com.gift.registry.services.impl;

import com.gift.registry.domain.InvoiceItem;
import com.gift.registry.repository.InvoiceItemRepository;
import com.gift.registry.services.InvoiceItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceItemServiceImpl implements InvoiceItemService{
    @Autowired
    private InvoiceItemRepository invoiceItemRepository;

    @Override
    public InvoiceItem find(Long id) {
        return invoiceItemRepository.findOne(id);
    }

    @Override
    public InvoiceItem persist(InvoiceItem entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InvoiceItem merge(InvoiceItem entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(InvoiceItem entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<InvoiceItem> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
