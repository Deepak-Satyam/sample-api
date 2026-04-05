package com.example.sampleapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "Sample Store API",
        version = "2.0.0",
        description = "Sample API for SpecShield CLI testing"
))
public class SampleApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleApiApplication.class, args);
    }
}
