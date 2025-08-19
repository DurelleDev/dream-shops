package com.Deisha.dreamshops.Service.Product;

import com.Deisha.dreamshops.model.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product searchProduct(long productId) {
        return null;
    }

    @Override
    public Product updateProduct(long productId, Product product) {
        return null;
    }


    public void deleteProduct(long productId) {

    }

    public List<Product> getAllProduct() {
        return null;
    }

    @Override
    public List<Product> getProductsByCategoryId(long categoryId) {
        return List.of();
    }

    @Override
    public List<Product> getProductByBrandId(Long productBrandId) {
        return List.of();
    }
}
