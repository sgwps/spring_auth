package com.sgwps.authapp.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sgwps.authapp.models.PrimitiveUser;

public interface UserRepository extends JpaRepository<PrimitiveUser, Long> {
    PrimitiveUser findByUsername(String username);    
}