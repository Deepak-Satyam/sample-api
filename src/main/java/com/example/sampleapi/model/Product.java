package com.example.sampleapi.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Product in the store")
public class Product {

    @Schema(description = "Unique product ID", example = "101")
    private Long id;

    @Schema(description = "Product name", example = "Wireless Keyboard")
    private String name;

    @Schema(description = "Price as formatted string", example = "$49.99")
    private String price;  // changed from number to string in v2 — BREAKING

    @Schema(description = "Product description")
    private String description;

    @Schema(description = "Stock quantity", example = "50")
    private Integer stock;  // new field in v2 — ADDITION

    public Product() {}
    public Product(Long id, String name, String price, String description, Integer stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getPrice() { return price; }
    public String getDescription() { return description; }
    public Integer getStock() { return stock; }
}
