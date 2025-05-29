package com.Ecommerce_Sale.Sale_Campaign_Management_System.Mapper;

import com.Ecommerce_Sale.Sale_Campaign_Management_System.DTO.CampaignDTO;
import com.Ecommerce_Sale.Sale_Campaign_Management_System.DTO.DiscountDTO;
import com.Ecommerce_Sale.Sale_Campaign_Management_System.Model.Campaign;
import com.Ecommerce_Sale.Sale_Campaign_Management_System.Model.Discount;

import java.util.List;
import java.util.stream.Collectors;

public class CampaignMapper {

    public static CampaignDTO toDTO(Campaign campaign, List<Discount> discounts) {
        CampaignDTO campaignDTO = new CampaignDTO();
        campaignDTO.setCampaignId(campaign.getCampaignId());
        campaignDTO.setCampaignTitle(campaign.getCampaignTitle());
        campaignDTO.setStartDate(campaign.getStartDate());
        campaignDTO.setEndDate(campaign.getEndDate());

        List<DiscountDTO> discountDTOs = discounts.stream().map(discount -> {
            DiscountDTO dto = new DiscountDTO();
            dto.setDiscountId(discount.getDiscountId());
            dto.setProductId(discount.getProduct().getProductId());
            dto.setCampaignId(discount.getCampaign().getCampaignId());
            dto.setDiscountPercentage(discount.getDiscountPercentage());
            return dto;
        }).collect(Collectors.toList());

        campaignDTO.setDiscounts(discountDTOs);
        return campaignDTO;
    }

    public static Campaign toEntity(CampaignDTO campaignDTO) {
        Campaign campaign = new Campaign();
        campaign.setCampaignId(campaignDTO.getCampaignId());
        campaign.setCampaignTitle(campaignDTO.getCampaignTitle());
        campaign.setStartDate(campaignDTO.getStartDate());
        campaign.setEndDate(campaignDTO.getEndDate());
        return campaign;
    }
}
