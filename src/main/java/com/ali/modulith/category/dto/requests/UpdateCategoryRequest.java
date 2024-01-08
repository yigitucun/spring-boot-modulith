package com.ali.modulith.category.dto.requests;

import jakarta.validation.constraints.NotBlank;

public class UpdateCategoryRequest {

    private long id;
    @NotBlank(message = "Zorunlu alan.")
    private String category;

    public UpdateCategoryRequest() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UpdateCategoryRequest(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category.trim();
    }
}
