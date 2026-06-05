package com.paymentchain.customer.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CustomerControllerTest {

    @Test
    void controllerClassShouldBeInstantiable() {
        assertNotNull(new CustomerRestController());
    }
}
