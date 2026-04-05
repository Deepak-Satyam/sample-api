package com.example.sampleapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Request body for creating a user")
public class CreateUserRequest {

    @NotBlank
    @Schema(description = "Full name", required = true, example = "Jane Smith")
    private String name;

    @NotBlank
    @Email
    @Schema(description = "Email address", required = true, example = "jane@example.com")
    private String email;

    // 'password' removed as required in v2 — MODIFICATION (was required in v1)
    @Schema(description = "Password (optional, for email/password accounts)", example = "secret123")
    private String password;

    @Schema(description = "Phone number", example = "+1-555-0100")
    private String phoneNumber;

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getPhoneNumber() { return phoneNumber; }
}
