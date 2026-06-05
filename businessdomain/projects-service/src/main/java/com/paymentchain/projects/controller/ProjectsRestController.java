package com.paymentchain.projects.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectsRestController {

	@GetMapping("/health")
	public String health() {
		return "projects-service ok";
	}
}

