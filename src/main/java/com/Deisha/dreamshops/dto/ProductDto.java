package com.Deisha.dreamshops.dto;

import com.Deisha.dreamshops.model.Category;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    private long productId;
    private String productName;
    private String productBrand;
    private BigDecimal productPrice;
    private int productQuantity;
    private String productDescription;
    private Category category;

}
