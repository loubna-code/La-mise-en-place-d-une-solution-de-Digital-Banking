package com.java.project.libre.services.imp;

import com.java.project.libre.entities.Role;
import com.java.project.libre.entities.User;
import com.java.project.libre.enumeratin.role;
import com.java.project.libre.repositories.roleRepository;
import com.java.project.libre.repositories.userRepository;
import com.java.project.libre.services.interfaces.userServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class userServiceImp implements userServiceInterface {
   @Autowired
   userRepository UserRepository;
    @Autowired
    roleRepository RoleRepository;
    @Override
    public void addUser(User user) {
        UserRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        UserRepository.deleteById(id);
    }

    @Override
    public <optional> User getUserById(Long id) {

        return UserRepository.getById(id);
    }

    @Override
    public <optional> User getUserByEmail(String email) {

        return UserRepository.getByEmail(email).get();
    }

    @Override
    public void UpdateUser(User user) {

    }

    @Override
    public Set<Role> getRolesByUser(String email) {

        return this.getUserByEmail(email).getRoles();
    }

    @Override
    public List<User> getAllUser() {
        return UserRepository.findAll();
    }

    @Override
    public void AddRoleToUser(String email, role Role) {
        User user=this.getUserByEmail(email);
        Optional<Role> role1=RoleRepository.findByRole(Role);
        Set<Role>roles=user.getRoles();
        if (role1.isPresent()) {

            roles.add(role1.get()); //
        }


        user.setRoles(roles);
    }

}
