package com.Deisha.dreamshops.Service.Product;

import com.Deisha.dreamshops.model.Product;

import java.util.List;

public interface ProductService{
    Product createProduct(Product product);
    Product searchProduct(long productId);
    Product updateProduct(long productId, Product product);
    void deleteProduct(long productId);

    List<Product> getAllProduct();
    List<Product> getProductsByCategoryId(long categoryId);
    List<Product> getProductByBrandId(Long productBrandId);
    List<Product> getProductByBrandAndCategory(String productBrand, String productCategory);
}
