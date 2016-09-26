package com.metall_a.orders_manager.app.service.impl;

import com.metall_a.orders_manager.app.infra.util.CommonUtil;
import com.metall_a.orders_manager.app.model.entity.order.SalesForm;
import com.metall_a.orders_manager.app.service.model_interfaces.SalesFormService;

import java.util.ArrayList;
import java.util.List;

/**
 * Default implementation of the {@link SalesForm}
 *
 * @author Vasiliy Kononenko
 */
public class SalesFormServiceImpl implements SalesFormService {
    /**
     * Internal list of salesForms
     */
    private final List<SalesForm> salesForms;
    /**
     * Auto-increment counter for entity id generation
     */
    private int counter = 0;

    public SalesFormServiceImpl() {
        salesForms = new ArrayList<>();
    }

    @Override
    public List<SalesForm> findSalesForms() {
        return CommonUtil.getSafeList(salesForms);
    }

    @Override
    public void saveSalesForm(SalesForm salesForm) {
        if (!salesForms.contains(salesForm)) {
            salesForm.setId(++counter);
            salesForms.add(salesForm);
        }
    }

    @Override
    public void deleteSalesForm(int id) {

    }

    @Override
    public void updateSalesForm(SalesForm salesForm) {

    }
}