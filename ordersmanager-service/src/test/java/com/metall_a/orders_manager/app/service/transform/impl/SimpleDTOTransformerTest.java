package com.metall_a.orders_manager.app.service.transform.impl;

import com.metall_a.orders_manager.app.infra.exeption.flow.InvalidParameterException;
import com.metall_a.orders_manager.app.model.entity.enums.Position;
import com.metall_a.orders_manager.app.model.entity.person.Account;
import com.metall_a.orders_manager.app.rest.dto.AccountDTO;
import com.metall_a.orders_manager.app.service.transform.Transformer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Verifies functionality of the {@link SimpleDTOTransformer}
 * unit
 *
 * @author Morenets
 */
public class SimpleDTOTransformerTest {
    private Transformer transformer;

    @Before
    public void setup() {
        transformer = new SimpleDTOTransformer();
    }

    @Test
    public void testTransformCitySuccess() {
        Account account = new Account("Jon");
        account.setId(1);
        account.setLastName("Morrison");
        account.setPhoneNumber("0935291647");
        account.setEmail("morrison@gmail.com");
        account.setUserName("morrison1991");
        account.setPassword("qwerty");
        account.setPosition(Position.DIRECTOR);

        AccountDTO dto = transformer.transform(account, AccountDTO.class);
        assertNotNull(dto);
        assertEquals(dto.getId(), account.getId());
        assertEquals(dto.getName(), account.getName());
        assertEquals(dto.getLastName(), account.getLastName());
        assertEquals(dto.getPhoneNumber(), account.getPhoneNumber());
        assertEquals(dto.getEmail(), account.getEmail());
        assertEquals(dto.getUserName(), account.getUserName());
        assertEquals(dto.getPassword(), account.getPassword());
        assertEquals(dto.getPosition(), account.getPosition());
    }

    @Test(expected = InvalidParameterException.class)
    public void testTransformNullCityFailure() {
        transformer.transform(null, AccountDTO.class);
    }

    @Test(expected = InvalidParameterException.class)
    public void testTransformNullDTOClassFailure() {
        transformer.transform(new Account("Jon"), null);
    }

    @Test
    public void testUnTransformCitySuccess() {
        AccountDTO dto = new AccountDTO();
        dto.setId(1);
        dto.setName("Jon");
        dto.setId(1);
        dto.setLastName("Morrison");
        dto.setPhoneNumber("0935291647");
        dto.setEmail("morrison@gmail.com");
        dto.setUserName("morrison1991");
        dto.setPassword("qwerty");
        dto.setPosition(Position.DIRECTOR);

        Account account = transformer.untransform(dto, Account.class);
        assertNotNull(account);
        assertEquals(dto.getId(), account.getId());
        assertEquals(dto.getName(), account.getName());
        assertEquals(dto.getLastName(), account.getLastName());
        assertEquals(dto.getPhoneNumber(), account.getPhoneNumber());
        assertEquals(dto.getEmail(), account.getEmail());
        assertEquals(dto.getUserName(), account.getUserName());
        assertEquals(dto.getPassword(), account.getPassword());
        assertEquals(dto.getPosition(), account.getPosition());

    }

    @Test(expected = InvalidParameterException.class)
    public void testUnTransformNullCityFailure() {
        transformer.untransform(null, Account.class);
    }

    @Test(expected = InvalidParameterException.class)
    public void testUnTransformNullEntityClassFailure() {
        transformer.untransform(new AccountDTO(), null);
    }
}