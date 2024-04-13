package com.example.projectreview.orgvegfruits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectreview.orgvegfruits.model.*;

public interface UserRepo extends JpaRepository<User,Integer>{
    
}