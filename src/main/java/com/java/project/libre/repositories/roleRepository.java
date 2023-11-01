package com.java.project.libre.repositories;

import com.java.project.libre.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface roleRepository extends JpaRepository<Role,Long> {
    <Optional>Role FindByName();
}
