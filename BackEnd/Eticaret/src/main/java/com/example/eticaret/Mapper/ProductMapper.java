package com.example.eticaret.Mapper;
import com.example.eticaret.DTO.ProductDTO;
import com.example.eticaret.Entity.Product;

public class ProductMapper {

    //Entity'den DTO'ya dönüşüm
    public ProductDTO toDTO(Product product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStockQuantity()
        );
    }
    //DTO'dan entity'e dönüş
    public Product toEntity(ProductDTO productDTO){
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStockQuantity(productDTO.getStockQuantity());
        return product;
    }
}
