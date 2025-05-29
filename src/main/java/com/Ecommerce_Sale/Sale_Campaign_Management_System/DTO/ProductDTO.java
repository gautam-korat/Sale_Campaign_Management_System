package com.Ecommerce_Sale.Sale_Campaign_Management_System.DTO;

public class ProductDTO {

    private Long productId;
    private String productName;
    private Double productMrp;
    private Double productDiscountPrice;
    private int productStock;

    // Default Constructor
    public ProductDTO()
    {

    }

    // Parameterized Constructor
    public ProductDTO(Long productId, String productName, Double productMrp, Double productDiscountPrice, int productStock) {
        this.productId = productId;
        this.productName = productName;
        this.productMrp = productMrp;
        this.productDiscountPrice = productDiscountPrice;
        this.productStock = productStock;
    }

    // Getter Setter

    public Double getProductDiscountPrice() {
        return productDiscountPrice;
    }

    public void setProductDiscountPrice(Double productDiscountPrice) {
        this.productDiscountPrice = productDiscountPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getProductMrp() {
        return productMrp;
    }

    public void setProductMrp(Double productMrp) {
        this.productMrp = productMrp;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }
}
