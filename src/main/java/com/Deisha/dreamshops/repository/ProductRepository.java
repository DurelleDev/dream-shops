package com.Deisha.dreamshops.repository;

import com.Deisha.dreamshops.dto.ProductDto;
import com.Deisha.dreamshops.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<ProductDto> findByProductName(String productName);
    List<ProductDto> findByProductBrand(String productBrand);
    List<ProductDto> findByProductNameAndProductBrand(String productName, String productBrand);
    List<ProductDto> findByCategoryCategoryName(String categoryName);
    List<ProductDto> findByProductBrandAndCategoryCategoryName(String productBrand, String productCategoryName);
    List<ProductDto> findByProductNameAndCategoryCategoryName(String productName, String productCategory);
    long countByProductNameAndProductBrand(String productName, String productBrand);
}
