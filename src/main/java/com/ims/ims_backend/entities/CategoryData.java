package com.ims.ims_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@NoArgsConstructor
//@AllArgsConstructor
//@Data
public class CategoryData {
    private Long id;
    private String name;
    private Long productAssigned;
    private String percentage;

    public CategoryData(Long id, String name, Long productAssigned, String percentage) {
        this.id = id;
        this.name = name;
        this.productAssigned = productAssigned;
        this.percentage = percentage;
    }

    public CategoryData() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProductAssigned() {
        return productAssigned;
    }

    public void setProductAssigned(Long productAssigned) {
        this.productAssigned = productAssigned;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}
