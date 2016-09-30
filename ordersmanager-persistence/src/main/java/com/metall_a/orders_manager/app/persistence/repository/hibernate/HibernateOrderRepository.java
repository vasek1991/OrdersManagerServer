package com.metall_a.orders_manager.app.persistence.repository.hibernate;

import com.metall_a.orders_manager.app.model.entity.order.Order;
import com.metall_a.orders_manager.app.persistence.hibernate.SessionFactoryBuilder;
import com.metall_a.orders_manager.app.persistence.repository.OrderRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import java.util.List;

public class HibernateOrderRepository implements OrderRepository {

    private final SessionFactory sessionFactory;

    @Inject
    public HibernateOrderRepository(SessionFactoryBuilder builder) {
        sessionFactory = builder.getSessionFactory();
    }

    @Override
    public void save(Order order) {

        try (Session session = sessionFactory.openSession()) {
            session.saveOrUpdate(order);
        }
    }

    @Override
    public Order findById(int cityId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Order.class, cityId);
        }
    }

    @Override
    public void delete(int cityId) {
        try (Session session = sessionFactory.openSession()) {
            Order order = session.get(Order.class, cityId);
            if (order != null) {
                session.delete(order);
            }
        }
    }

    @Override
    public List<Order> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createCriteria(Order.class).list();
        }
    }
}