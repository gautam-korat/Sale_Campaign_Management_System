package com.Ecommerce_Sale.Sale_Campaign_Management_System.Service;

import com.Ecommerce_Sale.Sale_Campaign_Management_System.DTO.CampaignDTO;
import com.Ecommerce_Sale.Sale_Campaign_Management_System.DTO.DiscountDTO;
import com.Ecommerce_Sale.Sale_Campaign_Management_System.Mapper.CampaignMapper;
import com.Ecommerce_Sale.Sale_Campaign_Management_System.Model.Campaign;
import com.Ecommerce_Sale.Sale_Campaign_Management_System.Model.Discount;
import com.Ecommerce_Sale.Sale_Campaign_Management_System.Model.History;
import com.Ecommerce_Sale.Sale_Campaign_Management_System.Model.Product;
import com.Ecommerce_Sale.Sale_Campaign_Management_System.Repository.CampaignRepository;
import com.Ecommerce_Sale.Sale_Campaign_Management_System.Repository.DiscountRepository;
import com.Ecommerce_Sale.Sale_Campaign_Management_System.Repository.HistoryRepository;
import com.Ecommerce_Sale.Sale_Campaign_Management_System.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CampaignService
{
    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DiscountRepository discountRepository;

    @Autowired
    private HistoryRepository historyRepository;

     // Campaign Start
    @Transactional
    public CampaignDTO startCampaign(CampaignDTO campaignDTO, List<DiscountDTO> discountDTOs)
    {
        //Campaign Save
        Campaign campaign = CampaignMapper.toEntity(campaignDTO);
        campaignRepository.save(campaign);

        // Discount Link to Product
        List<Discount> discounts = discountDTOs.stream().map(discountDTO ->
        {
            Discount discount = new Discount();
            discount.setCampaign(campaign);

            // Fetch Product
            Product product = productRepository.findById(discountDTO.getProductId()).orElseThrow(() -> new RuntimeException("❌ Product Not Found with ID: " + discountDTO.getProductId()));

            discount.setProduct(product);
            discount.setDiscountPercentage(discountDTO.getDiscountPercentage());
            return discount;
        }).collect(Collectors.toList());

        // Discount save
        discountRepository.saveAll(discounts);

        // Update Product Discount Price & Save The History
        for (Discount discount : discounts) {
            Product product = discount.getProduct();
            if (product != null)
            {
                // Apply Discount
                double newPrice = product.getProductMrp() - (product.getProductMrp() * discount.getDiscountPercentage() / 100);
                product.setProductDiscountPrice(newPrice);
                productRepository.save(product);

                // Save Data in History Table
                History history = new History();
                history.setCampaign(campaign);
                history.setProduct(product);
                history.setStartDate(campaign.getStartDate());
                history.setEndDate(campaign.getEndDate());
                history.setProductMrp(product.getProductMrp());
                history.setProductDiscountPrice(newPrice);
                historyRepository.save(history);
            }
        }
        return CampaignMapper.toDTO(campaign, discounts);
    }
    // Find Expired Campaign
    public List<Long> getExpiredCampaigns()
    {
        Date currentDate = new Date();
        return campaignRepository.findAll().stream().filter(campaign -> campaign.getEndDate().before(currentDate)).map(Campaign::getCampaignId).toList();
    }

    // Campaign End
    @Transactional
    public void endCampaign(Long campaignId)
    {
        Optional<Campaign> campaignOptional = campaignRepository.findById(campaignId);
        if (campaignOptional.isPresent())
        {
            Campaign campaign = campaignOptional.get();

            // Check The Campaign is Already Ended Or Not
            boolean alreadyEnded = historyRepository.findAll().stream().anyMatch(history -> history.getCampaign().getCampaignId().equals(campaignId) && history.getProductDiscountPrice().equals(history.getProductMrp()));

            if (alreadyEnded)
            {
                System.out.println("ℹ️ Campaign ID " + campaignId + " is Already Ended");
                return;
            }

            // Fetch The Campaign Related All Discount
            List<Discount> discounts = discountRepository.findAll()
                    .stream()
                    .filter(discount -> discount.getCampaign().getCampaignId().equals(campaignId))
                    .toList();

            if (discounts.isEmpty())
            {
                throw new RuntimeException("❌ No discount found for campaign ID: " + campaignId);
            }

            // All Campaign Reset The Discount Price & Save History
            for (Discount discount : discounts)
            {
                Product product = discount.getProduct();
                if (product != null)
                {
                    // Save Data in History Table
                    History history = new History();
                    history.setCampaign(campaign);
                    history.setProduct(product);
                    history.setStartDate(campaign.getStartDate());
                    history.setEndDate(campaign.getEndDate());
                    history.setProductMrp(product.getProductMrp());
                    history.setProductDiscountPrice(product.getProductMrp());
                    historyRepository.save(history);

                    // Reset The Product Discount Price
                    product.setProductDiscountPrice(product.getProductMrp());
                    productRepository.save(product);
                }
            }

            // Delete Campaign
            // campaignRepository.delete(campaign);

            // Delete History
            //historyRepository.deleteAll(historyRepository.findAll().stream().filter(history -> history.getCampaign().getCampaignId().equals(campaignId)).toList());
        }
        else
        {
            throw new RuntimeException("❌ Campaign not found with ID: " + campaignId);
        }
    }
}