package com.ali.modulith.category.business.rules;

import com.ali.modulith.category.dataAccess.abstracts.ICategoryRepository;
import com.ali.modulith.core.exceptions.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CategoryBusinessRules {
    private final ICategoryRepository categoryRepository;

    public CategoryBusinessRules(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public void checkIfCategory(String category){
        if (this.categoryRepository.existsByCategory(category)){
            throw new BusinessException("Kategori önceden eklenmiş", HttpStatus.BAD_REQUEST);
        }
    }

    public void checkIfCategoryId(long id){
        if (!this.categoryRepository.existsById(id)){
            throw new BusinessException("Kategori bulunamadı.",HttpStatus.BAD_REQUEST);
        }
    }

}
