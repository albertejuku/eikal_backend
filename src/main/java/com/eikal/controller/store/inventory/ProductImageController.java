package com.eikal.controller.store.inventory;


import com.eikal.error.GlobalError;
import com.eikal.models.store.inventory.ProductImage;
import com.eikal.service.store.inventory.ProductImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author David Kinyanjui
 */

@RestController
public class ProductImageController {

    private final ProductImageService productImageService;

    public ProductImageController(ProductImageService productImageService) {
        this.productImageService = productImageService;
    }
    @GetMapping("productImage/add")
    public ResponseEntity<?> addProductImage(@RequestBody ProductImage productImage) {
        ProductImage addedProductImage = productImageService.addProductImage(productImage);
        return addedProductImage != null ?
                ResponseEntity.status(201).body(addedProductImage) :
                ResponseEntity.status(400).body(new GlobalError((short) 400,"Product image was not added"));
    }

    @PutMapping("productImage/update")
    public ResponseEntity<?> updateProductImage(@RequestBody ProductImage productImage,@RequestParam Long id) {
        ProductImage updatedProductImage = productImageService.updateProductImage(productImage,id);
        return updatedProductImage != null ?
                ResponseEntity.status(201).body(updatedProductImage) :
                ResponseEntity.status(400).body(new GlobalError((short) 400,"Product image was not updated"));
    }
}
