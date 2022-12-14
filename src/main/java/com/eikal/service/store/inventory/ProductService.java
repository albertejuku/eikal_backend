package com.eikal.service.store.inventory;


import com.eikal.models.store.inventory.Product;
import com.eikal.repository.store.inventory.ProductRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductService {


    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product addProduct(Product product) {
        return productRepo.save(product);
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

    public Page<Product> findAllProducts(int page,int size) {
        return productRepo.findAll(PageRequest.of(page,size));
    }

    public Page<Product> findAllProductsByCategory(String category,int page,int size) {
        return productRepo.findAllByCategoryOrderByNameAsc(category, PageRequest.of(page,size));
    }

    public Product findProductsByCode(String itemCode) {
        return productRepo.findByItemCode(itemCode);
    }

    public Page<Product> findProductByManufacturer(Long id,int page,int size) {
        return productRepo.findAllByManufacturer_Id(id, PageRequest.of(page,size));
    }

    public Page<Product> findByTaxType(String type,int page,int size) {
        return productRepo.findByTax_Type(type, PageRequest.of(page,size));
    }

    public Page<Product> findByTaxAmount(double amount, int page, int size) {
        return productRepo.findByTax_Amount(amount,PageRequest.of(page,size));
    }
}
