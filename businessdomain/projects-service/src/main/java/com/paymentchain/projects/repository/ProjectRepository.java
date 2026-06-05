package com.paymentchain.projects.repository;

import com.paymentchain.projects.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}

