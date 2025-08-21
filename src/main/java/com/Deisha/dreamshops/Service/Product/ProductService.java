package com.Deisha.dreamshops.Service.Product;

import com.Deisha.dreamshops.model.Product;

import java.util.List;

public interface ProductService{
    Product createProduct(Product product);
    Product searchProduct(long productId);
    Product updateProduct(long productId, Product product);
    void deleteProduct(long productId);

    List<Product> getAllProduct();
    List<Product> getProductByName(String name);
    List<Product> getProductByBrand(String productBrand);
    List<Product> getProductByNameAndBrand(String productName, String productBrand);
    List<Product> getProductsByCategory(String productCategory);
    List<Product> getProductByBrandAndCategory(String productBrand, String productCategory);
    List<Product> getProductByNameAndCategory(String productName, String ProductCategory);

    long countProductsByNameAndBrand(String productName, String productBrand);



}
