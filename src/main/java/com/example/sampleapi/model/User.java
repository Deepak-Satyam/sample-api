package com.example.sampleapi.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "User account")
public class User {

    @Schema(description = "Unique user ID", example = "1")
    private Long id;

    @Schema(description = "Full name", example = "Jane Smith")
    private String name;

    @Schema(description = "Email address", example = "jane@example.com")
    private String emailAddress;  // renamed from 'email' in v2 — BREAKING

    @Schema(description = "Phone number", example = "+1-555-0100")
    private String phoneNumber;   // new field in v2 — ADDITION

    public User() {}
    public User(Long id, String name, String emailAddress, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmailAddress() { return emailAddress; }
    public String getPhoneNumber() { return phoneNumber; }
}
