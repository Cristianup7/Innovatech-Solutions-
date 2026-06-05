package com.paymentchain.projects.service;

import com.paymentchain.projects.entities.Project;
import com.paymentchain.projects.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    @Test
    void cuandoListAll_repositorioDevuelveLista_entoncesRetornaLista() {
        Project p1 = new Project("P1");
        p1.setId(1L);
        Project p2 = new Project("P2");
        p2.setId(2L);

        when(projectRepository.findAll()).thenReturn(List.of(p1, p2));

        List<Project> result = projectService.listAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("P1", result.get(0).getName());
        assertEquals(1L, result.get(0).getId());
        assertEquals("P2", result.get(1).getName());
        assertEquals(2L, result.get(1).getId());

        verify(projectRepository, times(1)).findAll();
    }

    @Test
    void cuandoListAll_repositorioDevuelveVacio_entoncesRetornaListaVacia() {
        when(projectRepository.findAll()).thenReturn(Collections.emptyList());

        List<Project> result = projectService.listAll();

        assertNotNull(result);
        assertTrue(result.isEmpty());

        verify(projectRepository, times(1)).findAll();
    }
}

