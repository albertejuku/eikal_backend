package com.eikal.controller.store.inventory;

import com.eikal.error.GlobalError;
import com.eikal.models.store.inventory.ProductImage;
import com.eikal.service.store.inventory.ProductImageService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

/**
 * @author David Kinyanjui
 */

@RestController
public class ProductImageController {

    private final ProductImageService productImageService;

    public ProductImageController(ProductImageService productImageService) {
        this.productImageService = productImageService;
    }

    @PostMapping("productImage/add")
    public ResponseEntity<?> addProductImage(@RequestBody ProductImage productImage, @RequestParam MultipartFile file) {
        ProductImage addedProductImage = productImageService.addProductImage(productImage,file);
        return addedProductImage != null ?
                ResponseEntity.status(201).body(addedProductImage) :
                ResponseEntity.status(400).body(new GlobalError((short) 400,"Not added"));
    }

    @PutMapping("productImage/update")
    public ResponseEntity<?> updateProductImage(@RequestParam Long id,@RequestBody ProductImage productImage,@RequestPart("file") MultipartFile file) {
        ProductImage updatedProductImage = productImageService.updateProductImage(id,productImage,file);
        return updatedProductImage != null ?
                ResponseEntity.status(201).body(updatedProductImage) :
                ResponseEntity.status(400).body(new GlobalError((short) 400,"Not updated"));
    }

    @GetMapping("productImage/")
    public ResponseEntity<?> findProductImage(@RequestParam Long id) {
        //find the ProductImage entity with the given ID
        Optional<ProductImage> optionalProductImage = productImageService.findProductImage(id);
        if(!optionalProductImage.isPresent()) {
            return ResponseEntity.status(404).body(new GlobalError((short) 404,"Not found"));
        }

        ProductImage productImage = optionalProductImage.get();

        //Read the image file from the product-images folder
        String filePath = productImage.getUrl();
        File file = new File(filePath);
        if(!file.exists()) {
            return ResponseEntity.status(404).body(new GlobalError((short) 404,"Not found"));
        }

        InputStream inputStream;

        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            return ResponseEntity.status(404).body(new GlobalError((short) 404,"Not found"));
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "image/" + FilenameUtils.getExtension(productImage.getFilename()));

        return ResponseEntity.status(200).headers(headers).body(new InputStreamResource(inputStream));
    }

    @GetMapping("productImage/all")
    public ResponseEntity<List<Resource>> findProductImages() {
        List<Resource> resourceList = productImageService.findProductImages();
        return !resourceList.isEmpty() ?
                ResponseEntity.status(200).body(resourceList) :
                ResponseEntity.status(404).build();
    }
}
