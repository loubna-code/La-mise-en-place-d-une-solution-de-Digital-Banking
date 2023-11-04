package com.java.project.libre.repositories;

import com.java.project.libre.entities.Role;
import com.java.project.libre.enumeratin.role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface roleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByRole(role role);
}
