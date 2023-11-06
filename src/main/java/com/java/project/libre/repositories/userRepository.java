package com.java.project.libre.repositories;

import com.java.project.libre.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<User,Long> {
  Optional<User> getByEmail(String email);
  Optional<User> findByEmail(String email);
  Boolean existsByEmail(String email);
}
