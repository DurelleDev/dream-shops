package com.Deisha.dreamshops.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    private long productId;
    private String productBrand;
    private BigDecimal productPrice;
    private String productDescription;

}
