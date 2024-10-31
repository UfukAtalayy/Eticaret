package com.example.eticaret.Repository;

import com.example.eticaret.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    //Fiyata göre ürünleri bul
    List<Product> findByPriceGreaterThan(BigDecimal price);

    // Belirli bir stok miktarından az olan ürünleri bul
    List<Product> findByStockQuantityLessThan(int quantity);

    // İsme göre ürün arama (case insensitive)
    List<Product> findByNameContainingIgnoreCase(String name);

    // Fiyat aralığında ürün bul
    List<Product> findByPriceBetween(BigDecimal minPrice,BigDecimal maxPrice);
}
