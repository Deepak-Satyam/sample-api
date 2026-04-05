package com.example.sampleapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
@Tag(name = "Orders", description = "Order management endpoints (new in v2)")
public class OrderController {

    @GetMapping
    @Operation(summary = "List all orders")
    @ApiResponse(responseCode = "200", description = "Orders retrieved successfully")
    public ResponseEntity<List<Map<String, Object>>> listOrders() {
        return ResponseEntity.ok(List.of(
                Map.of("id", 1, "userId", 1, "total", "$79.98", "status", "SHIPPED"),
                Map.of("id", 2, "userId", 2, "total", "$29.99", "status", "PENDING")
        ));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get order by ID")
    @ApiResponse(responseCode = "200", description = "Order found")
    @ApiResponse(responseCode = "404", description = "Order not found")
    public ResponseEntity<Map<String, Object>> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(Map.of("id", id, "userId", 1, "total", "$79.98", "status", "SHIPPED"));
    }
}
