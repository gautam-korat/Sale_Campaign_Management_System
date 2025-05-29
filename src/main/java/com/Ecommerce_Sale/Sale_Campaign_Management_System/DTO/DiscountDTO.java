package com.Ecommerce_Sale.Sale_Campaign_Management_System.DTO;

public class DiscountDTO {

    private Long discountId;
    private Long productId;
    private Long campaignId;
    private Double discountPercentage;

    // Default Constructor
    public DiscountDTO() {
    }

    // Parameterized Constructor
    public DiscountDTO(Long discountId, Long productId, Long campaignId, Double discountPercentage) {
        this.discountId = discountId;
        this.productId = productId;
        this.campaignId = campaignId;
        this.discountPercentage = discountPercentage;
    }

    // Getter Setter

    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
