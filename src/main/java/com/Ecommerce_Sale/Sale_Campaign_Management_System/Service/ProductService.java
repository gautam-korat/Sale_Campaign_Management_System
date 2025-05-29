package com.Ecommerce_Sale.Sale_Campaign_Management_System.Service;

import com.Ecommerce_Sale.Sale_Campaign_Management_System.DTO.ProductDTO;
import com.Ecommerce_Sale.Sale_Campaign_Management_System.Mapper.ProductMapper;
import com.Ecommerce_Sale.Sale_Campaign_Management_System.Model.Product;
import com.Ecommerce_Sale.Sale_Campaign_Management_System.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = ProductMapper.toEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.toDTO(savedProduct);
    }


    public List<ProductDTO> getPaginatedProducts(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Product> productPage = productRepository.findAll(pageable);
        return productPage.getContent()
                .stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }
}