package com.Ecommerce_Sale.Sale_Campaign_Management_System.DTO;

import java.util.Date;

public class HistoryDTO {

    private Long historyId;
    private Long campaignId;
    private Long productId;
    private Date startDate;
    private Date endDate;
    private Double productMrp;
    private Double productDiscountPrice;

    // Default Constructor
    public HistoryDTO() {
    }

    // Parameterized Constructor
    public HistoryDTO(Long historyId, Long campaignId, Long productId, Date startDate, Date endDate, Double productMrp, Double productDiscountPrice) {
        this.historyId = historyId;
        this.campaignId = campaignId;
        this.productId = productId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.productMrp = productMrp;
        this.productDiscountPrice = productDiscountPrice;
    }

    // Getter Setter

    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getProductMrp() {
        return productMrp;
    }

    public void setProductMrp(Double productMrp) {
        this.productMrp = productMrp;
    }

    public Double getProductDiscountPrice() {
        return productDiscountPrice;
    }

    public void setProductDiscountPrice(Double productDiscountPrice) {
        this.productDiscountPrice = productDiscountPrice;
    }
}
