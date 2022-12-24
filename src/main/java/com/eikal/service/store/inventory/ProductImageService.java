package com.eikal.service.store.inventory;


import com.eikal.models.store.inventory.ProductImage;
import com.eikal.repository.store.inventory.ProductImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author David Kinyanjui
 */
@Service
public class ProductImageService {

    @Autowired
    private ProductImageRepo productImageRepo;

    public void addProductImage(ProductImage productImage) {
        productImageRepo.save(productImage);
    }

    public ProductImage updateProductImage(ProductImage productImage, Long Id) {
        productImage.setId(Id);
        return productImageRepo.save(productImage);
    }

    public void deleteProductImage(Long Id) {
        productImageRepo.deleteById(Id);
    }


}
