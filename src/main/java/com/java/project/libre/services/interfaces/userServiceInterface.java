package com.java.project.libre.services.interfaces;

import com.java.project.libre.entities.Role;
import com.java.project.libre.entities.User;
import com.java.project.libre.enumeratin.role;


import java.util.List;
import java.util.Set;

public interface userServiceInterface {

    void addUser(User user);
    void deleteUser(Long id);
    <optional>User getUserById(Long id);
    <optional>User getUserByEmail(String email);
    void UpdateUser(User user);
    Set<Role> getRolesByUser(String email);
    List<User> getAllUser();
     void AddRoleToUser(String email , role Role) ;
    }
