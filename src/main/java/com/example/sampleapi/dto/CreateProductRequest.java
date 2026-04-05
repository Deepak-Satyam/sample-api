package com.example.sampleapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Request body for creating a product")
public class CreateProductRequest {

    @NotBlank
    @Schema(description = "Product name", required = true, example = "Wireless Keyboard")
    private String name;

    @NotNull
    @Schema(description = "Price as formatted string", required = true, example = "$49.99")
    private String price;

    @Schema(description = "Product description", example = "A compact wireless keyboard")
    private String description;

    @NotNull
    @Schema(description = "Stock quantity", required = true, example = "50")
    private Integer stock;

    public String getName() { return name; }
    public String getPrice() { return price; }
    public String getDescription() { return description; }
    public Integer getStock() { return stock; }
}
