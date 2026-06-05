package com.paymentchain.customer.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductResponseTest {

    @Test
    void gettersAndSetters_shouldWork() {
        ProductResponse response = new ProductResponse();

        response.setId(99L);
        response.setName("Cuenta Vista");
        response.setCode("CV");

        assertEquals(99L, response.getId());
        assertEquals("Cuenta Vista", response.getName());
        assertEquals("CV", response.getCode());
    }
}
