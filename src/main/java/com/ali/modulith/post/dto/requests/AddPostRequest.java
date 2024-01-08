package com.ali.modulith.post.dto.requests;

import jakarta.validation.constraints.NotBlank;

public class AddPostRequest {
    @NotBlank(message = "Zorunlu alan")
    private String title;
    @NotBlank(message = "Zorunlu alan")
    private String content;
    private int categoryId;

    public AddPostRequest() {
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
