package com.eikal.service.store.inventory;


import com.eikal.models.store.inventory.Product;
import com.eikal.repository.store.inventory.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public void addProduct(Product product) {
        productRepo.save(product);
    }

    public Product updateProduct(Product product, Long productId) {
        product.setId(productId);
        return productRepo.save(product);
    }

    public void deleteProductById(Long productId) {
        productRepo.deleteById(productId);
    }

    public Product findProductsById(Long productId) {
        return productRepo.findById(productId).orElse(null);
    }

    public List<Product> findAllProducts() {
        return productRepo.findAll();
    }

    public List<Product> findAllProductsByCategory(String category) {
        return productRepo.findAllByCategoryOrderByNameAsc(category);
    }
}
