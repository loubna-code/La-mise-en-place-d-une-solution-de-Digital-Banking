package com.java.project.libre.services.imp;



import com.java.project.libre.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.java.project.libre.entities.User;

@Service
public class UserDétailsServiceImpl implements UserDetailsService {
    @Autowired
    userRepository UserRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = UserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + email));

        return UserDétailsImpl.build(user);
    }

}