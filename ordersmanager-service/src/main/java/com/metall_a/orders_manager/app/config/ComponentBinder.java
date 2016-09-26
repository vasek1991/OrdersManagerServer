package com.metall_a.orders_manager.app.config;

import com.metall_a.orders_manager.app.persistence.repository.SalesFormRepository;
import com.metall_a.orders_manager.app.persistence.repository.inmemory.InMemorySalesFormRepository;
import com.metall_a.orders_manager.app.service.impl.SalesFormServiceImpl;
import com.metall_a.orders_manager.app.service.model_interfaces.SalesFormService;
import com.metall_a.orders_manager.app.service.transform.Transformer;
import com.metall_a.orders_manager.app.service.transform.impl.SimpleDTOTransformer;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;

/**
 * Binds bean implementations and implemented interfaces
 *
 * @author Kononenko Vasiliy
 */
public class ComponentBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(InMemorySalesFormRepository.class).to(SalesFormRepository.class).in(Singleton.class);
        bind(SimpleDTOTransformer.class).to(Transformer.class).in(Singleton.class);
        bind(SalesFormServiceImpl.class).to(SalesFormService.class).in(Singleton.class);
    }
}