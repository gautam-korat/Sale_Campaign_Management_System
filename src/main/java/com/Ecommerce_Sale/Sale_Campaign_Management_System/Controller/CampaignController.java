package com.Ecommerce_Sale.Sale_Campaign_Management_System.Controller;

import com.Ecommerce_Sale.Sale_Campaign_Management_System.DTO.CampaignDTO;
import com.Ecommerce_Sale.Sale_Campaign_Management_System.Service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/campaign")
public class CampaignController
{
    @Autowired

    private CampaignService campaignService;

    @PostMapping("/start-campaign")
    public ResponseEntity<CampaignDTO> startCampaign(@RequestBody CampaignDTO campaignDTO)
    {
        CampaignDTO startedCampaign = campaignService.startCampaign(campaignDTO, campaignDTO.getDiscounts());
        return ResponseEntity.ok(startedCampaign);
    }
}