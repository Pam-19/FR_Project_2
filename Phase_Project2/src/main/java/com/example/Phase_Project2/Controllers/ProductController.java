package com.example.Phase_Project2.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Phase_Project2.Models.Product;
import com.example.Phase_Project2.Services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

//    @GetMapping("/{id}")
//    public Optional<Product> getProductById(@PathVariable Long id) {
//        return productService.getProductById(id);
//    }
    @GetMapping("/{category}")
    public List<Product> getProductByCategory(@PathVariable String category) {
        return productService.getProductByCategory(category);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}