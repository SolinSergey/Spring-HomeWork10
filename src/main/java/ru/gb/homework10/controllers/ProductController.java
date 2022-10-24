package ru.gb.homework10.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.homework10.dto.ProductDto;
import ru.gb.homework10.entities.Product;
import ru.gb.homework10.services.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody ProductDto product) {
        productService.addProduct(product);

        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<?> deleteProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}
