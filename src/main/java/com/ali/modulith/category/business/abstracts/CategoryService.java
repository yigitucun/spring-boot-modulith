package com.ali.modulith.category.business.abstracts;

import com.ali.modulith.category.dto.requests.AddCategoryRequest;
import com.ali.modulith.category.dto.requests.UpdateCategoryRequest;
import com.ali.modulith.category.dto.responses.ListCategoryResponse;
import com.ali.modulith.category.projections.ListCategoryProjection;

import java.util.List;

public interface CategoryService {
    AddCategoryRequest add(AddCategoryRequest request);
    List<ListCategoryResponse> getAll();
    void delete(int id);
    ListCategoryProjection getById(int id);
    UpdateCategoryRequest update(UpdateCategoryRequest request);

}
