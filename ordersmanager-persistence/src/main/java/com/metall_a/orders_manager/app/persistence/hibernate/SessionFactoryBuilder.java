package com.metall_a.orders_manager.app.persistence.hibernate;

import com.metall_a.orders_manager.app.model.entity.order.*;
import com.metall_a.orders_manager.app.model.entity.person.Account;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import javax.annotation.PreDestroy;

/**
 * Component that is responsible for managing
 * Hibernate session factory
 *
 * @author Kononenko Vasiliy
 */
public class SessionFactoryBuilder {
    private final SessionFactory sessionFactory;

    public SessionFactoryBuilder() {
        ServiceRegistry registry = new StandardServiceRegistryBuilder().build();

        MetadataSources sources = new MetadataSources(registry);

        sources.addAnnotatedClass(Customer.class);
        sources.addAnnotatedClass(Material.class);
        sources.addAnnotatedClass(Order.class);
        sources.addAnnotatedClass(Purchase.class);
        sources.addAnnotatedClass(PurchaseRequest.class);
        sources.addAnnotatedClass(TechnicalCalculation.class);
        sources.addAnnotatedClass(Account.class);

        sessionFactory = sources.buildMetadata().buildSessionFactory();
    }

    /**
     * Returns single instance of session factory
     *
     * @return SessionFactory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @PreDestroy
    public void destroy() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}