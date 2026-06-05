package com.paymentchain.projects.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectsRestControllerTest {

    @Test
    void cuandoHealthEndpointEntoncesRetornaMensaje() {
        ProjectsRestController controller = new ProjectsRestController();
        assertEquals("projects-service ok", controller.health());
    }
}


