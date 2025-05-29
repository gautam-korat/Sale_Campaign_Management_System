package com.Ecommerce_Sale.Sale_Campaign_Management_System.Mapper;

import com.Ecommerce_Sale.Sale_Campaign_Management_System.DTO.DiscountDTO;
import com.Ecommerce_Sale.Sale_Campaign_Management_System.Model.Campaign;
import com.Ecommerce_Sale.Sale_Campaign_Management_System.Model.Discount;
import com.Ecommerce_Sale.Sale_Campaign_Management_System.Model.Product;

public class DiscountMapper {

    public static DiscountDTO toDTO(Discount discount) {
        DiscountDTO discountDTO = new DiscountDTO();
        discountDTO.setDiscountId(discount.getDiscountId());
        discountDTO.setProductId(discount.getProduct().getProductId());
        discountDTO.setCampaignId(discount.getCampaign().getCampaignId());
        discountDTO.setDiscountPercentage(discount.getDiscountPercentage());
        return discountDTO;
    }

    public static Discount toEntity(DiscountDTO discountDTO, Product product, Campaign campaign) {
        Discount discount = new Discount();
        discount.setDiscountId(discountDTO.getDiscountId());
        discount.setProduct(product);
        discount.setCampaign(campaign);
        discount.setDiscountPercentage(discountDTO.getDiscountPercentage());
        return discount;
    }
}
