package com.metall_a.orders_manager.app.persistence.repository.hibernate;

import com.metall_a.orders_manager.app.model.entity.order.Order;
import com.metall_a.orders_manager.app.persistence.hibernate.SessionFactoryBuilder;
import com.metall_a.orders_manager.app.persistence.repository.OrderRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;

public class HibernateOrderRepository implements OrderRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateOrderRepository.class);

    private final SessionFactory sessionFactory;

    @Inject
    public HibernateOrderRepository(SessionFactoryBuilder builder) {
        sessionFactory = builder.getSessionFactory();
    }

    @Override
    public void save(Order order) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.saveOrUpdate(order);
            tx.commit();
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    @Override
    public Order findById(long orderId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Order.class, orderId);
        }
    }

    @Override
    public void delete(long orderId) {
        try (Session session = sessionFactory.openSession()) {
            Order order = session.get(Order.class, orderId);
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