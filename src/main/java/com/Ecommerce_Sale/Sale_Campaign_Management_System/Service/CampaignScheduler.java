package com.Ecommerce_Sale.Sale_Campaign_Management_System.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CampaignScheduler
{
    @Autowired
    private CampaignService campaignService;

    //@Scheduled(cron = "0 0 0 * * ?") Mid Night 12 AM
    @Scheduled(fixedDelay = 60000)  // 1 Minute
    public void checkAndEndCampaigns()
    {
        List<Long> expiredCampaignIds = campaignService.getExpiredCampaigns();

        if (expiredCampaignIds != null && !expiredCampaignIds.isEmpty())
        {
            for (Long campaignId : expiredCampaignIds)
            {
                campaignService.endCampaign(campaignId);
                System.out.println("✅ Campaign Ended: " + campaignId);
            }
        }
        else
        {
            System.out.println("ℹ️ No expired campaigns found.");
        }
    }
}