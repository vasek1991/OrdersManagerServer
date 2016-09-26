package com.metall_a.orders_manager.app.service.impl;

import com.metall_a.orders_manager.app.model.entity.order.SalesForm;
import com.metall_a.orders_manager.app.persistence.repository.SalesFormRepository;
import com.metall_a.orders_manager.app.persistence.repository.inmemory.InMemorySalesFormRepository;
import com.metall_a.orders_manager.app.service.model_interfaces.SalesFormService;

import java.util.List;
import java.util.Optional;

/**
 * Default implementation of the {@link SalesForm}
 *
 * @author Vasiliy Kononenko
 */
public class SalesFormServiceImpl implements SalesFormService {
    private final SalesFormRepository salesFormRepository;

    public SalesFormServiceImpl() {
        salesFormRepository = new InMemorySalesFormRepository();
    }

    @Override
    public List<SalesForm> findSalesForms() {
        return salesFormRepository.findAll();
    }

    @Override
    public Optional<SalesForm> findSalesFormById(int id) {
        return Optional.ofNullable(salesFormRepository.findById(id));
    }

    @Override
    public void saveSalesForm(SalesForm salesForm) {
        salesFormRepository.save(salesForm);
    }

    @Override
    public void deleteSalesForm(int id) {

    }
}