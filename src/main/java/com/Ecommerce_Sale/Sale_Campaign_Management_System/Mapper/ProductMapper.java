package com.Ecommerce_Sale.Sale_Campaign_Management_System.Mapper;

import com.Ecommerce_Sale.Sale_Campaign_Management_System.DTO.ProductDTO;
import com.Ecommerce_Sale.Sale_Campaign_Management_System.Model.Product;

public class ProductMapper {

    public static ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setProductName(product.getProductName());
        productDTO.setProductMrp(product.getProductMrp());
        productDTO.setProductDiscountPrice(product.getProductDiscountPrice());
        productDTO.setProductStock(product.getProductStock());
        return productDTO;
    }

    public static Product toEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductId(productDTO.getProductId());
        product.setProductName(productDTO.getProductName());
        product.setProductMrp(productDTO.getProductMrp());
        product.setProductDiscountPrice(productDTO.getProductDiscountPrice());
        product.setProductStock(productDTO.getProductStock());
        return product;
    }
}