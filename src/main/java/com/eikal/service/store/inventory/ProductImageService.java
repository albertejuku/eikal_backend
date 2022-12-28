package com.eikal.service.store.inventory;


import com.eikal.models.store.inventory.ProductImage;
import com.eikal.repository.store.inventory.ProductImageRepo;
import org.springframework.stereotype.Service;

/**
 * @author David Kinyanjui
 */
@Service
public class ProductImageService {


    private final ProductImageRepo productImageRepo;

    public ProductImageService(ProductImageRepo productImageRepo) {
        this.productImageRepo = productImageRepo;
    }

    public ProductImage addProductImage(ProductImage productImage) {
        return productImageRepo.save(productImage);
    }

    public ProductImage updateProductImage(ProductImage productImage, Long id) {
        productImage.setId(id);
        return productImageRepo.save(productImage);
    }

    public void deleteProductImage(Long id) {
        productImageRepo.deleteById(id);
    }

}
