package com.java.project.libre.services.imp;

import com.java.project.libre.DTO.userDTO;
import com.java.project.libre.entities.Role;
import com.java.project.libre.entities.User;
import com.java.project.libre.enumeratin.role;
import com.java.project.libre.repositories.roleRepository;
import com.java.project.libre.repositories.userRepository;
import com.java.project.libre.services.interfaces.AuthServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

public class AuthServiceInterfaceImp implements AuthServiceInterface {
    @Autowired
    userRepository UserRepository;
    @Autowired
    roleRepository RoleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Override
    public Boolean signUp(userDTO user) {
        if (UserRepository.existsByEmail(user.getEmail())) {
            return false;
        }

        User newuser = new User();

        newuser.setEmail(user.getEmail());
        newuser.setPassword(encoder.encode(user.getPassword()));

        Set<String> strRoles = user.getRoles();
        Set<Role> roles = new HashSet<>();


        if (strRoles == null) {

                Role userRole = RoleRepository.findByRole(role.valueOf("role_user"))
                        .orElseThrow(() -> new RuntimeException("Le rôle est introuvable."));
                roles.add(userRole);

        } else {
            strRoles.forEach(Role -> {
                switch (Role) {
                    case "role_admin":
                        Role adminRole = RoleRepository.findByRole(role.valueOf("role_admin"))
                                .orElseThrow(() -> new RuntimeException("Le rôle est introuvable."));
                        roles.add(adminRole);
                        break;


                    default:
                        Role userRole = RoleRepository.findByRole(role.valueOf("role_user"))
                                .orElseThrow(() -> new RuntimeException("Le rôle est introuvable."));
                        roles.add(userRole);
                }
            });
        }

        newuser.setRoles(roles);
        UserRepository.save(newuser);
        return true;
    }
}
