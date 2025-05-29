package com.Ecommerce_Sale.Sale_Campaign_Management_System.Repository;

import com.Ecommerce_Sale.Sale_Campaign_Management_System.Model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long>
{

}
