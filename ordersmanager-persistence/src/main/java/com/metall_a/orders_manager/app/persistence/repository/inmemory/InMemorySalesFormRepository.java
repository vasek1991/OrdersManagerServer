package com.metall_a.orders_manager.app.persistence.repository.inmemory;


import com.metall_a.orders_manager.app.infra.util.CommonUtil;
import com.metall_a.orders_manager.app.model.entity.order.SalesForm;
import com.metall_a.orders_manager.app.persistence.repository.SalesFormRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory implementation of the {@link SalesFormRepository} that stores
 * data in the RAM
 *
 * @author Vasiliy Kononenko
 */
public class InMemorySalesFormRepository implements SalesFormRepository {
    /**
     * Internal list of salesForms
     */
    private final List<SalesForm> salesForms;

    /**
     * Auto-increment counter for entity id generation
     */
    private int counter = 0;

    public InMemorySalesFormRepository() {
        salesForms = new ArrayList<>();
    }

    @Override
    public void delete(final int salesFormId) {
    }

    @Override
    public List<SalesForm> findAll() {
        return CommonUtil.getSafeList(salesForms);
    }

    @Override
    public void save(final SalesForm salesForm) {
        if (!salesForms.contains(salesForm)) {
            salesForm.setId(++counter);
            salesForms.add(salesForm);
        }
    }

    @Override
    public SalesForm findById(final int id) {
        return salesForms.stream()
                .filter(salesForm -> salesForm.getId() == id)
                .findFirst()
                .orElse(null);
    }
}