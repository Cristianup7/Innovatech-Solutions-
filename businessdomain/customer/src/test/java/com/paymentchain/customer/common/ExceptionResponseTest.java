package com.paymentchain.customer.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExceptionResponseTest {

    @Test
    void allArgsConstructor_shouldAssignAllFields() {
        ExceptionResponse response = new ExceptionResponse(
                "Business",
                "Regla de negocio",
                "E100",
                "detalle de error",
                "/customer/1"
        );

        assertEquals("Business", response.getType());
        assertEquals("Regla de negocio", response.getTittle());
        assertEquals("E100", response.getCode());
        assertEquals("detalle de error", response.getDetail());
        assertEquals("/customer/1", response.getInstance());
    }
}
