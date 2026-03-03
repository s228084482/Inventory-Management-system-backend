package com.ims.ims_backend.entities;

public class ProductInfo {
    private String supplierName;
    private String moveType;
    private String category;

    public ProductInfo(String supplierName, String moveType, String category) {
        this.supplierName = supplierName;
        this.moveType = moveType;
        this.category = category;
    }

    public ProductInfo() {
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getMoveType() {
        return moveType;
    }

    public void setMoveType(String moveType) {
        this.moveType = moveType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
