package com.eikal.controller.store.inventory;


import com.eikal.error.GlobalError;
import com.eikal.models.store.inventory.Product;
import com.eikal.service.store.inventory.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author David Kinyanjui
 */

@RestController
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("product/add")
    public ResponseEntity<?> addProduct(Product product) {
        Product addedProduct = productService.addProduct(product);
        return addedProduct != null ?
                ResponseEntity.status(201).body(addedProduct) :
                ResponseEntity.status(400).body(new GlobalError((short) 400, "Not added"));
    }

    @PutMapping("product/update")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @RequestParam Long id) {
        Product updateProduct = productService.updateProduct(product,id);
        return updateProduct != null ?
                ResponseEntity.status(201).body(updateProduct) :
                ResponseEntity.status(400).body(new GlobalError((short) 400, "Not updated"));
    }

    @GetMapping("product/{id}")
    public ResponseEntity<?> findProductsById(@PathVariable Long id) {
        Product product = productService.findProductsById(id);
        return product != null ?
                ResponseEntity.status(200).body(product) :
                ResponseEntity.status(404).body(new GlobalError((short) 404,"Not found"));
    }

    @GetMapping("product/all")
    public ResponseEntity<?> findAllProducts(@RequestParam int page,@RequestParam int size) {
        Page<Product> allProductsPage = productService.findAllProducts(page,size);
        return ResponseEntity.status(200).body(allProductsPage);
    }

    @GetMapping("product/category")
    public ResponseEntity<?> findAllProductsByCategory(@RequestParam String category,@RequestParam int page,@RequestParam int size) {
        Page<Product> productPage = productService.findAllProductsByCategory(category,page,size);
        return ResponseEntity.status(200).body(productPage);
    }

    @GetMapping("product/productCode")
    public ResponseEntity<?> findProductsByCode(@RequestParam String itemCode) {
        Product product = productService.findProductsByCode(itemCode);
        return product != null ?
                ResponseEntity.status(200).body(product) :
                ResponseEntity.status(404).body(new GlobalError((short) 404, "Not found"));
    }

    @GetMapping("product/productManufacturer")
    public ResponseEntity<?> findProductByManufacturer(@RequestParam Long id,@RequestParam int page,@RequestParam int size) {
        Page<Product> productPage = productService.findProductByManufacturer(id,page,size);
        return ResponseEntity.status(200).body(productPage);
    }

    @GetMapping("product/taxType")
    public ResponseEntity<?> findByTaxType(@RequestParam String type,@RequestParam int page,@RequestParam int size) {
        Page<Product> productPage = productService.findByTaxType(type,page,size);
        return ResponseEntity.status(200).body(productPage);
    }

    @GetMapping("product/taxAmount")
    public ResponseEntity<?> findByTaxAmount(@RequestParam double amount, @RequestParam int page,@RequestParam int size) {
        Page<Product> productPage = productService.findByTaxAmount(amount,page,size);
        return ResponseEntity.status(200).body(productPage);
    }
}
