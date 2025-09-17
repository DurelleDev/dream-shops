package com.Deisha.dreamshops.dto;

import com.Deisha.dreamshops.model.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {
        private long categoryId;
        private String categoryName;

        @JsonIgnore
        private List<Product> products;
}
