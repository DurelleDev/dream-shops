package com.Deisha.dreamshops.Service.Impl;

import com.Deisha.dreamshops.Exceptions.ProductNotFoundException;
import com.Deisha.dreamshops.Service.Product.ProductService;
import com.Deisha.dreamshops.dto.ProductDto;
import com.Deisha.dreamshops.dto.ProductResponse;
import com.Deisha.dreamshops.dto.ProductUpdateDto;
import com.Deisha.dreamshops.model.Category;
import com.Deisha.dreamshops.model.Product;
import com.Deisha.dreamshops.repository.CategoryRepository;
import com.Deisha.dreamshops.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

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
        return productRepository.save(mapToEntity(productDto,category));
    }


    public ProductDto searchProduct(long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new ProductNotFoundException("Product Not found"));
        return mapToDto(product);
    }

    @Override
    public ProductUpdateDto updateProduct(long productId, ProductUpdateDto updatedProduct) {

        Product product = productRepository.findById(productId).orElseThrow(
                ()-> new ProductNotFoundException("User not found with ID: " + productId)
        );

        product.setProductName(updatedProduct.getProductName());
        product.setProductBrand(updatedProduct.getProductBrand());
        product.setProductPrice(updatedProduct.getProductPrice());
        product.setProductQuantity(updatedProduct.getProductQuantity());
        product.setProductDescription(updatedProduct.getProductDescription());

        Category category = categoryRepository.findByCategoryName(updatedProduct.getCategory().getCategoryName());
        product.setCategory(updatedProduct.getCategory());

        return updatedProduct;
    }

    @Override
    public void deleteProduct(long productId) {
        productRepository.findById(productId)
                .ifPresentOrElse(productRepository::delete, ()->{
                    throw new ProductNotFoundException("Product not found. Cannot be deleted!!!");
                });
    }

    @Override
    public ProductResponse getAllProducts() {
        ProductResponse productResponse = new ProductResponse();

        List<Product> productContent = productRepository.findAll();
        List<ProductDto> content = productContent.stream().map(this::mapToDto).toList();

        productResponse.setContent(content);

        return productResponse;
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
        productDto.setProductName(product.getProductName());
        productDto.setProductBrand(product.getProductBrand());
        productDto.setProductPrice(product.getProductPrice());
        productDto.setProductQuantity(product.getProductQuantity());
        productDto.setProductDescription(product.getProductDescription());
        productDto.setCategory(product.getCategory());

        return productDto;
    }
    private Product mapToEntity(ProductDto productDto, Category category){
        Product product = new Product();

        product.setProductId(productDto.getProductId());
        product.setProductName(productDto.getProductName());
        product.setProductBrand(productDto.getProductBrand());
        product.setProductPrice(productDto.getProductPrice());
        product.setProductQuantity(productDto.getProductQuantity());
        product.setProductDescription(productDto.getProductDescription());
        product.setCategory(category);

        return product;
    }




}
