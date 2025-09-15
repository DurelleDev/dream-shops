package com.Deisha.dreamshops.controllers;

import com.Deisha.dreamshops.Service.Product.ProductService;
import com.Deisha.dreamshops.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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





}
