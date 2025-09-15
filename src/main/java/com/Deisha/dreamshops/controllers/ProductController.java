package com.Deisha.dreamshops.controllers;

import com.Deisha.dreamshops.Service.Product.ProductService;
import com.Deisha.dreamshops.dto.ProductDto;
import com.Deisha.dreamshops.dto.ProductResponse;
import com.Deisha.dreamshops.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("products")
    public ResponseEntity<ProductResponse> getAllProducts(){
        ProductResponse productResponse = new ProductResponse();
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("products/create")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.addProduct(productDto), HttpStatus.CREATED);
    }

    @PutMapping("products/{id}/update")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") long productId, @RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.updateProduct(productId, productDto), HttpStatus.ACCEPTED);
    }





}
