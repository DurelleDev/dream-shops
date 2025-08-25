package com.Deisha.dreamshops.Service.Impl;

import com.Deisha.dreamshops.Exceptions.ProductNotFoundException;
import com.Deisha.dreamshops.Service.Product.ProductService;
import com.Deisha.dreamshops.dto.ProductDto;
import com.Deisha.dreamshops.dto.ProductResponse;
import com.Deisha.dreamshops.model.Category;
import com.Deisha.dreamshops.model.Product;
import com.Deisha.dreamshops.repository.CategoryRepository;
import com.Deisha.dreamshops.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

//@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Product addProduct(ProductDto productDto) {
        //check if the category is found in the DB
        //yes: set as new product category
        //No: save it as new category and then set it to the product

        Category category = Optional.ofNullable(categoryRepository.findByCategoryName(productDto.getCategory().getCategoryName()))
                .orElseGet(()->{
                    Category newCategory = new Category(productDto.getCategory().getCategoryName());
                    return categoryRepository.save(newCategory);
                });

        productDto.setCategory(category);




        return null;
    }


    public ProductDto searchProduct(long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new ProductNotFoundException("Product Not found"));
        return mapToDto(product);
    }

    @Override
    public ProductDto updateProduct(long productId, ProductDto product) {
        return null;
    }

    @Override
    public void deleteProduct(long productId) {
        productRepository.findById(productId)
                .ifPresentOrElse(productRepository::delete, ()->{
                    throw new ProductNotFoundException("Product not found. Cannot be deleted!!!");
                });
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        ProductResponse productResponse = new ProductResponse();

        return List.of();
    }

    @Override
    public List<ProductDto> getProductByName(String productName) {
        return productRepository.findByProductName(productName);
    }

    @Override
    public List<ProductDto> getProductByBrand(String productBrand) {
        return productRepository.findByProductBrand(productBrand);
    }

    @Override
    public List<ProductDto> getProductByNameAndBrand(String productName, String productBrand) {
        return productRepository.findByProductNameAndProductBrand(productName, productBrand);
    }

    @Override
    public List<ProductDto> getProductsByCategory(String productCategory) {
        return productRepository.findByCategoryCategoryName(productCategory);
    }

    @Override
    public List<ProductDto> getProductByBrandAndCategory(String productBrand, String productCategory) {
        return productRepository.findByProductBrandAndCategoryCategoryName(productBrand,productCategory);
    }

    @Override
    public List<ProductDto> getProductByNameAndCategory(String productName, String productCategory) {
        return productRepository.findByProductNameAndCategoryCategoryName(productName, productCategory);
    }

    @Override
    public long countProductsByNameAndBrand(String productName, String productBrand) {
        return productRepository.countByProductNameAndProductBrand(productName, productBrand);
    }

    private ProductDto mapToDto(Product product){
        ProductDto productDto = new ProductDto();

        productDto.setProductId(product.getProductId());
        productDto.setProductBrand(product.getProductBrand());
        productDto.setProductPrice(product.getProductPrice());
        productDto.setProductQuantity(product.getProductQuantity());
        productDto.setProductDescription(product.getProductDescription());

        return productDto;
    }
    private Product mapToEntity(ProductDto productDto, Category category){
        return new Product(
        productDto.getProductName(),
        productDto.getProductBrand(),
        productDto.getProductPrice(),
        productDto.getProductQuantity(),
        productDto.getProductDescription(),
        category
);
    }




}
