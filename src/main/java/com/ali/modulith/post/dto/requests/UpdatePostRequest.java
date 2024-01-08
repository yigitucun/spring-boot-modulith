package com.ali.modulith.post.dto.requests;

import jakarta.validation.constraints.NotBlank;

public class UpdatePostRequest {
    private int id;
    @NotBlank(message = "Zorunlu alan")
    private String title;
    @NotBlank(message = "Zorunlu alan")
    private String content;
    private int categoryId;

    public UpdatePostRequest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
