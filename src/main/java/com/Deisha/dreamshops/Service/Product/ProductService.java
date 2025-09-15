package com.Deisha.dreamshops.Service.Product;

import com.Deisha.dreamshops.dto.ProductDto;
import com.Deisha.dreamshops.dto.ProductResponse;
import com.Deisha.dreamshops.dto.ProductUpdateDto;
import com.Deisha.dreamshops.model.Product;

import java.util.List;

public interface ProductService{
    Product addProduct(ProductDto product);
    ProductDto searchProduct(long productId);
    ProductUpdateDto updateProduct(long productId, ProductUpdateDto existingProduct);

    void deleteProduct(long productId);

    ProductResponse getAllProducts();
    List<ProductDto> getProductByName(String name);
    List<ProductDto> getProductByBrand(String productBrand);
    List<ProductDto> getProductByNameAndBrand(String productName, String productBrand);
    List<ProductDto> getProductsByCategory(String productCategory);
    List<ProductDto> getProductByBrandAndCategory(String productBrand, String productCategory);
    List<ProductDto> getProductByNameAndCategory(String productName, String ProductCategory);

    long countProductsByNameAndBrand(String productName, String productBrand);



}
