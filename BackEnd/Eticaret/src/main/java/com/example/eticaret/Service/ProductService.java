package com.example.eticaret.Service;

import com.example.eticaret.Entity.Product;
import com.example.eticaret.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public boolean deleteProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Optional<Product> updateProduct(Long id, Product productDetails) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product productToUpdate = existingProduct.get();
            productToUpdate.setName(productDetails.getName());
            productToUpdate.setDescription(productDetails.getDescription());
            productToUpdate.setPrice(productDetails.getPrice());
            productToUpdate.setStockQuantity(productDetails.getStockQuantity());
            return Optional.of(productRepository.save(productToUpdate));
        } else {
            return Optional.empty();
        }
    }
}
