package com.example.projectreview.orgvegfruits.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.projectreview.orgvegfruits.model.*;
import com.example.projectreview.orgvegfruits.repository.*;

@Service
public class ProductService {
    
    @Autowired
    ProductRepo productRepository;

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public boolean updateProduct(int id, Product product) {
        if (!productRepository.existsById(id)) {
            return false;
        }
        product.setId(id);
        productRepository.save(product);
        return true;
    }

    public boolean deleteProduct(int id) {
        if (!productRepository.existsById(id)) {
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }

    public List<Product> getAllProductsSortedBy(String sortBy) {
        return productRepository.findAll(Sort.by(sortBy));
    }

    public Page<Product> getAllProductsPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return productRepository.findAll(pageable);
    }

    public List<Product> findByProductName(String productName) {
        return productRepository.findByProductName(productName);
    }

    public List<Product> findByUserId(int userId) {
        return productRepository.findByUserId(userId);
    }

}
