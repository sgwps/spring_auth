package com.sgwps.authapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sgwps.authapp.models.PrimitiveUser;
import com.sgwps.authapp.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService  {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PrimitiveUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }
    

    public boolean createUser(PrimitiveUser user) {
        try {
            userRepository.save(user);
        } catch (OptimisticLockingFailureException ex) {
            return false;
        }
        return true;
    }
}
