package com.metall_a.orders_manager.app.schema;

import com.google.common.collect.Sets;
import com.metall_a.orders_manager.app.model.entity.order.*;
import com.metall_a.orders_manager.app.model.entity.person.Account;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

import java.util.EnumSet;
import java.util.Set;

/**
 * {@link Export} dynamically generates SQL schema
 *
 * @author Kononenko Vasiliy
 */
public class Export {
    /**
     * Creates file with DDL statements to create project database from scratch
     * using specified dialect
     *
     * @param folder  String
     * @param dialect some Class extends Dialect
     */
    private static void exportDatabase(String folder, Class<? extends Dialect> dialect) {
        MetadataSources metadata = new MetadataSources(
                new StandardServiceRegistryBuilder().applySetting("hibernate.dialect", dialect.getName()).build());

        Set<Class<?>> entityClasses = Sets.newHashSet(Account.class, Customer.class, Material.class, Order.class,
                Purchase.class, PurchaseRequest.class, TechnicalCalculation.class);
        entityClasses.forEach(metadata::addAnnotatedClass);

        SchemaExport schema = new SchemaExport();
        schema.setDelimiter(";");
        schema.setOutputFile(folder + "schema_" + dialect.getSimpleName() + ".sql");

        schema.create(EnumSet.of(TargetType.SCRIPT), metadata.buildMetadata());
    }

    public static void main(String[] args) {
        exportDatabase("", MySQL5Dialect.class);
    }

}