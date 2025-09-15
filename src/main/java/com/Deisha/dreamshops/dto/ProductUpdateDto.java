package com.Deisha.dreamshops.dto;

import com.Deisha.dreamshops.model.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductUpdateDto {
    private long productId;
    private String productName;
    private String productBrand;
    private BigDecimal productPrice;
    private int productQuantity;
    private String productDescription;
    private Category category;
}
