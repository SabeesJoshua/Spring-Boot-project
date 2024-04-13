package com.example.projectreview.orgvegfruits.repository;
import com.example.projectreview.orgvegfruits.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.productName = ?1")
    List<Product> findByProductName(String productName);
    
    @Query("SELECT p FROM Product p WHERE p.id IN (SELECT DISTINCT p.id FROM Product p INNER JOIN p.users u WHERE u.id = ?1)")
    List<Product> findByUserId(int userId);
}