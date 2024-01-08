package com.ali.modulith.category.business.concretes;

import com.ali.modulith.category.business.abstracts.CategoryService;
import com.ali.modulith.category.business.rules.CategoryBusinessRules;
import com.ali.modulith.category.dataAccess.abstracts.ICategoryRepository;
import com.ali.modulith.category.dto.requests.AddCategoryRequest;
import com.ali.modulith.category.dto.requests.UpdateCategoryRequest;
import com.ali.modulith.category.dto.responses.ListCategoryResponse;
import com.ali.modulith.category.entities.concretes.Category;
import com.ali.modulith.category.projections.ListCategoryProjection;
import com.ali.modulith.core.utils.modelMapper.ModelMapperService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryManager implements CategoryService {
    private final ICategoryRepository categoryRepository;
    private final ModelMapperService  mapperService;
    private final CategoryBusinessRules categoryBusinessRules;

    public CategoryManager(ICategoryRepository categoryRepository, ModelMapperService mapperService, CategoryBusinessRules categoryBusinessRules) {
        this.categoryRepository = categoryRepository;
        this.mapperService = mapperService;
        this.categoryBusinessRules = categoryBusinessRules;
    }

    @Override
    public void delete(int id) {
        this.categoryBusinessRules.checkIfCategoryId(id);
        this.categoryRepository.deleteById(id);
    }

    @Override
    public UpdateCategoryRequest update(UpdateCategoryRequest request) {
        this.categoryBusinessRules.checkIfCategoryId(request.getId());
        this.categoryRepository.save(this.mapperService.toEntity(Category.class,request));
        return request;
    }

    @Override
    public ListCategoryProjection getById(int id) {
        this.categoryBusinessRules.checkIfCategoryId(id);
        return this.categoryRepository.findById(id);
    }

    @Override
    public AddCategoryRequest add(AddCategoryRequest request){
        this.categoryBusinessRules.checkIfCategory(request.getCategory());
        this.categoryRepository.save(this.mapperService.toEntity(Category.class,request));
        return request;
    }
    @Override
    public List<ListCategoryResponse> getAll(){
        List<ListCategoryProjection> categories = this.categoryRepository.findCategories();
        return this.mapperService.toEntity(categories, ListCategoryResponse.class);
    }

}
