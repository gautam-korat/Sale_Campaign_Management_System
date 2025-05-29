package com.Ecommerce_Sale.Sale_Campaign_Management_System.DTO;

import java.util.Date;
import java.util.List;

public class CampaignDTO {

    private Long campaignId;
    private String campaignTitle;
    private Date startDate;
    private Date endDate;
    private List<DiscountDTO> discounts;

    // Default Constructor
    public CampaignDTO() {
    }

    // Parameterized Constructor
    public CampaignDTO(Long campaignId, String campaignTitle, Date startDate, Date endDate, List<DiscountDTO> discounts) {
        this.campaignId = campaignId;
        this.campaignTitle = campaignTitle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discounts = discounts;
    }


    // Getter Setter
    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaignTitle() {
        return campaignTitle;
    }

    public void setCampaignTitle(String campaignTitle) {
        this.campaignTitle = campaignTitle;
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

    public List<DiscountDTO> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<DiscountDTO> discounts) {
        this.discounts = discounts;
    }
}
