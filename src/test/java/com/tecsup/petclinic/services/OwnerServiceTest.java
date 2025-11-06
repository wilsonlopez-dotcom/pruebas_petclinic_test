package com.tecsup.petclinic.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Owner;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OwnerServiceTest {

    @Autowired
    private OwnerService ownerService;

    @Test
    public void testCreateOwner() {
        Owner owner = new Owner();
        owner.setFirstName("Juan");
        owner.setLastName("Perez");
        owner.setAddress("Av. Lima 123");
        owner.setCity("Lima");
        owner.setTelephone("999888777");

        Owner saved = ownerService.create(owner);
        assertNotNull(saved.getId());
    }
}
