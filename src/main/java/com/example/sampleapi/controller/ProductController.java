package com.example.sampleapi.controller;

import com.example.sampleapi.dto.CreateProductRequest;
import com.example.sampleapi.model.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Products", description = "Product catalog endpoints")
public class ProductController {

    @GetMapping
    @Operation(summary = "List all products")
    @ApiResponse(responseCode = "200", description = "Products retrieved successfully")
    public ResponseEntity<List<Product>> listProducts() {
        return ResponseEntity.ok(List.of(
                new Product(101L, "Wireless Keyboard", "$49.99", "A compact wireless keyboard", 50),
                new Product(102L, "USB-C Hub", "$29.99", "7-in-1 USB-C hub", 120)
        ));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by ID")
    @ApiResponse(responseCode = "200", description = "Product found")
    @ApiResponse(responseCode = "404", description = "Product not found")
    public ResponseEntity<Product> getProduct(
            @Parameter(description = "Product ID") @PathVariable Long id) {
        return ResponseEntity.ok(new Product(id, "Wireless Keyboard", "$49.99", "A compact wireless keyboard", 50));
    }

    @PostMapping
    @Operation(summary = "Create a new product")
    @ApiResponse(responseCode = "201", description = "Product created")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequest req) {
        Product created = new Product(999L, req.getName(), req.getPrice(), req.getDescription(), req.getStock());
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a product")
    @ApiResponse(responseCode = "204", description = "Product deleted")
    @ApiResponse(responseCode = "404", description = "Product not found")
    public ResponseEntity<Void> deleteProduct(
            @Parameter(description = "Product ID") @PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
