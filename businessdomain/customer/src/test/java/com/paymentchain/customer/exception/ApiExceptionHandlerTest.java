package com.paymentchain.customer.exception;

import com.paymentchain.customer.common.BusinessRulesException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApiExceptionHandlerTest {

    private final ApiExceptionHandler handler = new ApiExceptionHandler();

    @Test
    void handlerUnknowHostException_shouldReturn500() {
        Exception ex = new Exception("io error");

        ResponseEntity<?> response = handler.handlerUnknowHostException(ex);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    void handlerBusinessErrorException_shouldReturnConfiguredStatus() {
        BusinessRulesException ex = new BusinessRulesException("221", HttpStatus.PRECONDITION_FAILED, "Error de comunicación");

        ResponseEntity<?> response = handler.handlerBusinessErrorException(ex);

        assertEquals(HttpStatus.PRECONDITION_FAILED, response.getStatusCode());
    }
}
