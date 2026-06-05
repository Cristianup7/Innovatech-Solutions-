package com.paymentchain.projects.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectEntityTest {

    @Test
    void cuandoConstructorVacio_crearYSettearCampos() {
        Project project = new Project();

        assertNull(project.getId());
        assertNull(project.getName());

        project.setId(1L);
        project.setName("Test Project");

        assertEquals(1L, project.getId());
        assertEquals("Test Project", project.getName());
    }

    @Test
    void cuandoConstructorConNombre_crearYObtenerNombre() {
        Project project = new Project("Nombre");

        assertNull(project.getId());
        assertEquals("Nombre", project.getName());

        project.setId(10L);
        assertEquals(10L, project.getId());
    }
}

