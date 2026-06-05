package com.paymentchain.customer.controller;

import com.paymentchain.customer.entities.Customer;
import com.paymentchain.customer.entities.CustomerProduct;
import com.paymentchain.customer.entities.ProductResponse;
import com.paymentchain.customer.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CustomerRestControllerTest {

    private final CustomerRepository customerRepository = org.mockito.Mockito.mock(CustomerRepository.class);
    private final WebClient.Builder webClientBuilder = org.mockito.Mockito.mock(WebClient.Builder.class);

    private final CustomerRestController customerRestController = new CustomerRestController();

    private final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(customerRestController)
            .setControllerAdvice(new com.paymentchain.customer.exception.ApiExceptionHandler())
            .build();

    CustomerRestControllerTest() throws Exception {
        injectField(customerRestController, "customerRepository", customerRepository);
        injectField(customerRestController, "webClientBuilder", webClientBuilder);
    }

    @SuppressWarnings("unchecked")
    @Test
    void list_shouldReturnOk() throws Exception {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Juan");
        customer.setProducts(Collections.emptyList());

        when(customerRepository.findAll()).thenReturn(List.of(customer));

        mockMvc.perform(get("/customer").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @SuppressWarnings("unchecked")
    @Test
    void getById_shouldReturnNotFound_whenCustomerDoesNotExist() throws Exception {
        when(customerRepository.findById(99L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/customer/99").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @SuppressWarnings("unchecked")
    @Test
    void getById_shouldReturnOkAndEnrichedProducts_whenCustomerExists() throws Exception {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Maria");

        CustomerProduct relation = new CustomerProduct();
        relation.setProductId(10L);
        customer.setProducts(List.of(relation));

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

        WebClient webClient = org.mockito.Mockito.mock(WebClient.class);
        WebClient.RequestHeadersUriSpec requestHeadersUriSpec = org.mockito.Mockito.mock(WebClient.RequestHeadersUriSpec.class);
        WebClient.ResponseSpec responseSpec = org.mockito.Mockito.mock(WebClient.ResponseSpec.class);

        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(10L);
        productResponse.setName("Cuenta Corriente");
        productResponse.setCode("CC");

        when(webClientBuilder.build()).thenReturn(webClient);
        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(any(String.class), ArgumentMatchers.<Object>any())).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(ProductResponse.class)).thenReturn(Mono.just(productResponse));

        mockMvc.perform(get("/customer/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.products[0].productId", is(10)))
                .andExpect(jsonPath("$.products[0].productName", is("Cuenta Corriente")));
    }


    @SuppressWarnings("unchecked")
    @Test
    void post_shouldReturnOk() throws Exception {
        Customer saved = new Customer();
        saved.setId(4L);
        saved.setName("Ana");
        saved.setPhone("999");
        saved.setProducts(Collections.emptyList());

        when(customerRepository.save(any(Customer.class))).thenReturn(saved);

        mockMvc.perform(post("/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Ana\",\"phone\":\"999\",\"products\":[]}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(4)))
                .andExpect(jsonPath("$.name", is("Ana")));
    }

    @SuppressWarnings("unchecked")
    @Test
    void delete_shouldReturnOk() {
        doNothing().when(customerRepository).deleteById(5L);

        customerRestController.delete(5L);

        verify(customerRepository).deleteById(5L);
    }

    private static void injectField(Object target, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}
