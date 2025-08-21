package com.Deisha.dreamshops.Service.Product;

import com.Deisha.dreamshops.Exceptions.ProductNotFoundException;
import com.Deisha.dreamshops.model.Product;
import com.Deisha.dreamshops.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product searchProduct(long productId) {
        return Optional.of(productRepository.findById(productId))
                .orElseThrow(()-> new ProductNotFoundException("Product not found!"));
    }

    @Override
    public Product updateProduct(long productId, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(long productId) {
        Optional.of(productRepository.findById(productId)).ifPresentOrElse(productRepository::delete,
                ()->{
                    throw new ProductNotFoundException("Product not present. cannot be deleted");
                });
    }

    @Override
    public List<Product> getAllProduct() {
        return List.of();
    }

    @Override
    public List<Product> getProductByName(String name) {
        return List.of();
    }

    @Override
    public List<Product> getProductByBrand(String productBrand) {
        return List.of();
    }

    @Override
    public List<Product> getProductByNameAndBrand(String productName, String productBrand) {
        return List.of();
    }

    @Override
    public List<Product> getProductsByCategory(String productCategory) {
        return List.of();
    }

    @Override
    public List<Product> getProductByBrandAndCategory(String productBrand, String productCategory) {
        return List.of();
    }

    @Override
    public List<Product> getProductByNameAndCategory(String productName, String ProductCategory) {
        return List.of();
    }

    @Override
    public long countProductsByNameAndBrand(String productName, String productBrand) {
        return 0;
    }
}
