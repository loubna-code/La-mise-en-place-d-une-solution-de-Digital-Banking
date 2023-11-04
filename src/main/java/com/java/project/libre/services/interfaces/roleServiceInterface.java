package com.java.project.libre.services.interfaces;

import com.java.project.libre.entities.Role;
import com.java.project.libre.entities.User;
import com.java.project.libre.enumeratin.role;

import java.util.List;

public interface roleServiceInterface {
    Role getRoleByName(role role);
    List<User> getUsersByRole(role role);
    List<Role> getAllRole();
    void addRole(Role role);
}
