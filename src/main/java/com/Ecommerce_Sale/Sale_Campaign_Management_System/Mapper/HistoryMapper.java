package com.Ecommerce_Sale.Sale_Campaign_Management_System.Mapper;

import com.Ecommerce_Sale.Sale_Campaign_Management_System.DTO.HistoryDTO;
import com.Ecommerce_Sale.Sale_Campaign_Management_System.Model.Campaign;
import com.Ecommerce_Sale.Sale_Campaign_Management_System.Model.History;
import com.Ecommerce_Sale.Sale_Campaign_Management_System.Model.Product;

public class HistoryMapper {

    public static HistoryDTO toDTO(History history) {
        HistoryDTO historyDTO = new HistoryDTO();
        historyDTO.setHistoryId(history.getHistoryId());
        historyDTO.setCampaignId(history.getCampaign().getCampaignId());
        historyDTO.setProductId(history.getProduct().getProductId());
        historyDTO.setStartDate(history.getStartDate());
        historyDTO.setEndDate(history.getEndDate());
        historyDTO.setProductMrp(history.getProductMrp());
        historyDTO.setProductDiscountPrice(history.getProductDiscountPrice());
        return historyDTO;
    }

    public static History toEntity(HistoryDTO historyDTO, Product product, Campaign campaign) {
        History history = new History();
        history.setHistoryId(historyDTO.getHistoryId());
        history.setCampaign(campaign);
        history.setProduct(product);
        history.setStartDate(historyDTO.getStartDate());
        history.setEndDate(historyDTO.getEndDate());
        history.setProductMrp(historyDTO.getProductMrp());
        history.setProductDiscountPrice(historyDTO.getProductDiscountPrice());
        return history;
    }
}
