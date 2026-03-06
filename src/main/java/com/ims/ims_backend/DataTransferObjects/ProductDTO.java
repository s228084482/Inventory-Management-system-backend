package com.ims.ims_backend.DataTransferObjects;

public class ProductDTO {
    private String productName;
    private float price;
    private Long quantity;
    private String description;
    private String supplierName;
    private String move;
    private String category_name;
    private String user_name;

    public ProductDTO(String productName, float price, Long quantity, String description, String supplierName, String move, String category_name, String user_name) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.supplierName = supplierName;
        this.move = move;
        this.category_name = category_name;
        this.user_name = user_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public ProductDTO() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
