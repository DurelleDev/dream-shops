package com.Deisha.dreamshops.Service.Category;

import com.Deisha.dreamshops.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto getCategoryById(Long categoryId);
    CategoryDto getCategoryByName(String categoryName);
    List<CategoryDto> getAllCategories();
    CategoryDto addCategory(CategoryDto category);
    CategoryDto updateCategory(CategoryDto category);
    void deleteCategoryById(Long categoryId);





}
