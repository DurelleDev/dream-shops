package com.Deisha.dreamshops.Service.Category;

import com.Deisha.dreamshops.Exceptions.CategoryNotFoundException;
import com.Deisha.dreamshops.dto.CategoryDto;
import com.Deisha.dreamshops.model.Category;
import com.Deisha.dreamshops.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDto getCategoryById(Long categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new CategoryNotFoundException("Category not found"));

        return mapToDto(category);
    }

    @Override
    public CategoryDto getCategoryByName(String categoryName) {
        return mapToDto(categoryRepository.findByCategoryName(categoryName));
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = categoryList.stream()
                .map(this::mapToDto).toList();

        CategoryDto categoryDto = new CategoryDto();
        return categoryDtoList;

    }

    @Override
    public CategoryDto addCategory(CategoryDto category) {
        return null;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto category) {
        return null;
    }

    @Override
    public void deleteCategoryById(Long categoryId) {

    }


    private CategoryDto mapToDto(Category category){
        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setCategoryId(category.getCategoryId());
        categoryDto.setCategoryName(category.getCategoryName());
        categoryDto.setProducts(category.getProducts());

        return categoryDto;
    }
}
