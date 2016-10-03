package com.metall_a.orders_manager.app.model.entity.order;

import com.metall_a.orders_manager.app.model.entity.base.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Customer  information
 *
 * @author Vasiliy Kononenko
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "CUSTOMER")
@Entity
public class Customer extends AbstractEntity {
    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "NAME", nullable = false, unique = true, length = 50)
    private String name;
    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "PHONE_NUMBER", nullable = false, length = 50)
    private String phoneNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Customer customer = (Customer) o;

        return name.equals(customer.name);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}