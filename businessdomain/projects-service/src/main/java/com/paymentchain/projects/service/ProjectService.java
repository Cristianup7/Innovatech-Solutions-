package com.paymentchain.projects.service;

import com.paymentchain.projects.entities.Project;
import com.paymentchain.projects.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

	private final ProjectRepository projectRepository;

	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	public List<Project> listAll() {
		return projectRepository.findAll();
	}
}

