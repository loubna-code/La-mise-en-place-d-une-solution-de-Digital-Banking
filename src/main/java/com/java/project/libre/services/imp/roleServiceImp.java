package com.java.project.libre.services.imp;

import com.java.project.libre.entities.Role;
import com.java.project.libre.entities.User;
import com.java.project.libre.enumeratin.role;
import com.java.project.libre.services.interfaces.roleServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class roleServiceImp implements roleServiceInterface {

    @Override
    public Role getRoleByName(role role) {
        return null;
    }

    @Override
    public List<User> getUsersByRole(role role) {
        return null;
    }

    @Override
    public List<Role> getAllRole() {
        return null;
    }

    @Override
    public void addRole(Role role) {

    }

}
