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
	@Bean
	CommandLineRunner start( roleServiceInterface roleS, userServiceInterface userS){
		return args->{

			roleS.addRole(new Role(null , role.valueOf("role_user"),new HashSet<>()));
			roleS.addRole(new Role(null , role.valueOf("role_admin"), new HashSet<>()));

			userS.addUser(new User(null ,"moubarikloubna1@gmail.com","loubna123", new HashSet<>()));
			userS.addUser(new User(null ,"gouaicheoussama@gmail.com","loubna123", new HashSet<>()));

			userS.AddRoleToUser("moubarikloubna1@gmail.com",role.valueOf("role_admin"));
			userS.AddRoleToUser("gouaicheoussama@gmail.com",role.valueOf("role_user"));




		};

	}


}
