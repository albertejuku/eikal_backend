package com.eikal.service.store.inventory;


import com.eikal.models.store.ResourceNotFoundException;
import com.eikal.models.store.inventory.ProductImage;
import com.eikal.repository.store.inventory.ProductImageRepo;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * @author David Kinyanjui
 */
@Service
public class ProductImageService {

    private final ProductImageRepo productImageRepo;
    private final ResourceLoader resourceLoader;

    private final String storageLocation = "product-images";

    public ProductImageService(ProductImageRepo productImageRepo,ResourceLoader resourceLoader) {
        this.productImageRepo = productImageRepo;
        this.resourceLoader = resourceLoader;
    }

    @Transactional
    public ProductImage addProductImage(ProductImage productImage,MultipartFile file) {

        //check if the product directory exists, and create it if it doesn't
        Path productImageDirectoryPath = Paths.get(storageLocation);

        if(!Files.exists(productImageDirectoryPath)) {
            try {
                Files.createDirectory(productImageDirectoryPath);
            } catch (IOException e) {
                System.out.println(e.getMessage());;
            }
        }

        String fileName = getFileName(file,productImage);

        //Save the image to the product-images folder
        try {
            file.transferTo(Paths.get(storageLocation +  "/" + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Save the image record to the database
        productImage.setUrl(storageLocation +  "/" + fileName);
        productImage.setFilename(fileName);

        return productImageRepo.save(productImage);
    }

    public String getFileName(MultipartFile file,ProductImage productImage) {

        //Generate a unique image ID
        String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
        String imageId = String.valueOf(productImage.getId());
        String fileName = imageId + file.getOriginalFilename() +
                "." + fileExtension;

        return fileName;
    }

    @Transactional
    public ProductImage updateProductImage(Long id,ProductImage productImage,MultipartFile file) {
        productImage = productImageRepo.findById(id).orElseThrow(() -> new
                ResourceNotFoundException("Not found"));

        String filePath = productImage.getUrl();
        try {
            file.transferTo(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        productImage.setFilename(file.getOriginalFilename());
        return productImageRepo.save(productImage);
    }

    public Optional<ProductImage> findProductImage(Long id) {
        return productImageRepo.findById(id);
    }

    public InputStream findProductImageFile(Long id) {
        Optional<ProductImage> productImage = findProductImage(id);
        if(productImage.isPresent()) {
            try {
                return new FileInputStream(new File(productImage.get().getUrl()));
            } catch (FileNotFoundException e) {
                throw new ResourceNotFoundException("Not found");
            }
        } else {
            throw new ResourceNotFoundException("Not found");
        }
    }

    public List<Resource> findProductImages() {
        List<ProductImage> productImages = productImageRepo.findAll();

        return productImages.stream()
                .map(productImage -> resourceLoader.getResource("file:" +
                        productImage.getUrl()))
                .collect(Collectors.toList());
    }
}
