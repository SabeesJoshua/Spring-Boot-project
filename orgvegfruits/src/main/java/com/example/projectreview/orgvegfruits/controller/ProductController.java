package com.example.projectreview.orgvegfruits.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.projectreview.orgvegfruits.model.*;
import com.example.projectreview.orgvegfruits.service.*;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product newProduct = productService.create(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
        Product product = productService.getProductById(id).orElse(null);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        if (productService.updateProduct(id, product)) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") int id) {
        if (productService.deleteProduct(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<Product>> getAllProductsSorted(@RequestParam String sortBy) {
        List<Product> products = productService.getAllProductsSortedBy(sortBy);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Product>> getAllProductsPaginated(@RequestParam int pageNo, @RequestParam int pageSize) {
        Page<Product> productsPage = productService.getAllProductsPaginated(pageNo, pageSize);
        return new ResponseEntity<>(productsPage, HttpStatus.OK);
    }

    @GetMapping("/name/{productName}")
    public ResponseEntity<List<Product>> getProductsByProductName(@PathVariable String productName) {
        List<Product> products = productService.findByProductName(productName);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Product>> getProductsByUserId(@PathVariable int userId) {
        List<Product> products = productService.findByUserId(userId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
