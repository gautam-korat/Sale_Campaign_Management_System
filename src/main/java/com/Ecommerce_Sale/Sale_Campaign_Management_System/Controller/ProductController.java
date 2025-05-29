package com.Ecommerce_Sale.Sale_Campaign_Management_System.Controller;

import com.Ecommerce_Sale.Sale_Campaign_Management_System.DTO.ProductDTO;
import com.Ecommerce_Sale.Sale_Campaign_Management_System.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController
{
    @Autowired
    private ProductService productService;

    @PostMapping("/add-product") // http://localhost:8080/product/add-product
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO)
    {
        ProductDTO savedProduct = productService.addProduct(productDTO);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping("/paginated") // http://localhost:8080/product/paginated?startPageNumber=0&productsPerPage=2
//    public ResponseEntity<List<ProductDTO>> getPaginatedProducts(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int pageSize)
//    {
//        List<ProductDTO> products = productService.getPaginatedProducts(page, pageSize);
//        return ResponseEntity.ok(products);
//    }
    public ResponseEntity<List<ProductDTO>> getPaginatedProducts(
            @RequestParam int startPageNumber,
            @RequestParam int productsPerPage ) {
        List<ProductDTO> products = productService.getPaginatedProducts(startPageNumber, productsPerPage );
        return ResponseEntity.ok(products);
    }
}