package com.metall_a.orders_manager.app.config;

import com.metall_a.orders_manager.app.persistence.hibernate.SessionFactoryBuilder;
import com.metall_a.orders_manager.app.persistence.repository.OrderRepository;
import com.metall_a.orders_manager.app.persistence.repository.PurchaseRequestRepository;
import com.metall_a.orders_manager.app.persistence.repository.hibernate.HibernateOrderRepository;
import com.metall_a.orders_manager.app.persistence.repository.inmemory.InMemoryPurchaseRequestRepository;
import com.metall_a.orders_manager.app.service.impl.OrderServiceImpl;
import com.metall_a.orders_manager.app.service.impl.PurchaseRequestServiceImpl;
import com.metall_a.orders_manager.app.service.model_interfaces.OrderService;
import com.metall_a.orders_manager.app.service.model_interfaces.PurchaseRequestService;
import com.metall_a.orders_manager.app.service.transform.Transformer;
import com.metall_a.orders_manager.app.service.transform.impl.SimpleDTOTransformer;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;

/**
 * Binds bean implementations and implemented interfaces
 *
 * @author Kononenko Vasiliy
 */
class ComponentBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(InMemoryPurchaseRequestRepository.class).to(PurchaseRequestRepository.class).in(Singleton.class);
        //bind(InMemoryOrderRepository.class).to(OrderRepository.class).in(Singleton.class);
        bind(HibernateOrderRepository.class).to(OrderRepository.class).in(Singleton.class);
        bind(SimpleDTOTransformer.class).to(Transformer.class).in(Singleton.class);
        bind(OrderServiceImpl.class).to(OrderService.class).in(Singleton.class);
        bind(PurchaseRequestServiceImpl.class).to(PurchaseRequestService.class).in(Singleton.class);
        bind(SessionFactoryBuilder.class).to(SessionFactoryBuilder.class).in(Singleton.class);
    }
}