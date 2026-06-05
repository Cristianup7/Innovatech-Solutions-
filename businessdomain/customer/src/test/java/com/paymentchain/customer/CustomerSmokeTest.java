package com.paymentchain.customer;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.paymentchain.customer.CustomerApplication;
import org.junit.jupiter.api.Test;

class CustomerSmokeTest {

    @Test
    void smokeApplicationContext() {
        assertNotNull(new CustomerApplication());
    }
}

