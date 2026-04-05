package com.example.sampleapi.controller;

import com.example.sampleapi.dto.CreateUserRequest;
import com.example.sampleapi.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Users", description = "User management endpoints")
public class UserController {

    @GetMapping
    @Operation(summary = "List all users")
    @ApiResponse(responseCode = "200", description = "Users retrieved successfully")
    public ResponseEntity<List<User>> listUsers() {
        return ResponseEntity.ok(List.of(
                new User(1L, "Jane Smith", "jane@example.com", "+1-555-0100"),
                new User(2L, "John Doe", "john@example.com", null)
        ));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID")
    @ApiResponse(responseCode = "200", description = "User found")
    @ApiResponse(responseCode = "404", description = "User not found")
    public ResponseEntity<User> getUser(
            @Parameter(description = "User ID") @PathVariable Long id) {
        return ResponseEntity.ok(new User(id, "Jane Smith", "jane@example.com", "+1-555-0100"));
    }

    @PostMapping
    @Operation(summary = "Create a new user")
    @ApiResponse(responseCode = "201", description = "User created")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest req) {
        User created = new User(99L, req.getName(), req.getEmail(), req.getPhoneNumber());
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
