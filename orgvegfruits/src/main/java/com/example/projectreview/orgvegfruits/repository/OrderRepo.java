package com.example.projectreview.orgvegfruits.repository;
import com.example.projectreview.orgvegfruits.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepo extends JpaRepository<Order, Integer> {
}