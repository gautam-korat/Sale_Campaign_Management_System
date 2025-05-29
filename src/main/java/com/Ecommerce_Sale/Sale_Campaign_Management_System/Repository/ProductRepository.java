package com.Ecommerce_Sale.Sale_Campaign_Management_System.Repository;

import com.Ecommerce_Sale.Sale_Campaign_Management_System.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{

}
