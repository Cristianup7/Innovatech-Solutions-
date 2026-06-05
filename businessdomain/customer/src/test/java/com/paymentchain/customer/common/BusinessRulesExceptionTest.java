package com.paymentchain.customer.common;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BusinessRulesExceptionTest {

    @Test
    void constructor_withIdCodeStatusAndMessage_shouldPopulateFields() {
        BusinessRulesException ex = new BusinessRulesException(1L, "C001", HttpStatus.BAD_REQUEST, "detalle");

        assertEquals(1L, ex.getId());
        assertEquals("C001", ex.getCode());
        assertEquals(HttpStatus.BAD_REQUEST, ex.getHttpStatus());
        assertEquals("detalle", ex.getMessage());
    }

    @Test
    void constructor_withMensajeAndMessage_shouldPopulateMensaje() {
        BusinessRulesException ex = new BusinessRulesException(2L, "C002", HttpStatus.CONFLICT, "mensaje", "detalle");

        assertEquals(2L, ex.getId());
        assertEquals("C002", ex.getCode());
        assertEquals(HttpStatus.CONFLICT, ex.getHttpStatus());
        assertEquals("mensaje", ex.getMensaje());
        assertEquals("detalle", ex.getMessage());
    }

    @Test
    void constructor_withIdAndMessage_shouldPopulateBasicFields() {
        BusinessRulesException ex = new BusinessRulesException(3L, "detalle basico");

        assertEquals(3L, ex.getId());
        assertEquals("detalle basico", ex.getMessage());
    }

    @Test
    void constructor_withCodeStatusAndMessage_shouldPopulateCodeAndStatus() {
        BusinessRulesException ex = new BusinessRulesException("C221", HttpStatus.PRECONDITION_FAILED, "fallo externo");

        assertEquals("C221", ex.getCode());
        assertEquals(HttpStatus.PRECONDITION_FAILED, ex.getHttpStatus());
        assertEquals("fallo externo", ex.getMessage());
    }
}
