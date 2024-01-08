package com.ali.modulith.category.dataAccess.abstracts;

import com.ali.modulith.category.entities.concretes.Category;
import com.ali.modulith.category.projections.ListCategoryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer> {
    boolean existsByCategory(String category);
    @Query("SELECT c.id as id,c.category as category from Category c")
    List<ListCategoryProjection> findCategories();
    boolean existsById(long id);
    ListCategoryProjection findById(long id);

}
