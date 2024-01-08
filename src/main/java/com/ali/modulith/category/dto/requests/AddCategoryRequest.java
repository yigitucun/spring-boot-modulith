package com.ali.modulith.category.dto.requests;

import jakarta.validation.constraints.NotBlank;

public class AddCategoryRequest {
    @NotBlank(message = "Zorunlu alan.")
    private String category;

    public AddCategoryRequest() {
    }

    public AddCategoryRequest(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category.trim();
    }
}
