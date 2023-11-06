package com.java.project.libre;

import com.java.project.libre.entities.Role;
import com.java.project.libre.entities.User;
import com.java.project.libre.enumeratin.role;
import com.java.project.libre.services.interfaces.roleServiceInterface;
import com.java.project.libre.services.interfaces.userServiceInterface;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableJpaRepositories
public class ProjectLibreApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProjectLibreApplication.class, args);
	}





   }
