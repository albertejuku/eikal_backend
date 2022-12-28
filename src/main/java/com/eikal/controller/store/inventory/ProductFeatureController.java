package com.eikal.controller.store.inventory;


import com.eikal.error.GlobalError;
import com.eikal.models.store.inventory.ProductFeatures;
import com.eikal.service.store.inventory.ProductFeatureService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author David Kinyanjui
 */

@RestController
public class ProductFeatureController {

    private final ProductFeatureService productFeatureService;

    public ProductFeatureController(ProductFeatureService productFeatureService) {
        this.productFeatureService = productFeatureService;
    }

    @PostMapping("productFeature/add")
    public ResponseEntity<?> addProductFeature(@RequestBody ProductFeatures productFeatures) {
        ProductFeatures addedProductFeature = productFeatureService.addProductFeature(productFeatures);
        return addedProductFeature != null ?
                ResponseEntity.status(201).body(addedProductFeature) :
                ResponseEntity.status(400).body(new GlobalError((short) 400, "Product feature not added"));
    }

    @PutMapping("productFeature/update")
    public ResponseEntity<?> updateProductFeature(@RequestBody ProductFeatures productFeatures,@RequestParam Long id) {
        ProductFeatures updatedProductFeatures = productFeatureService.updateProductFeature(productFeatures,id);
        return updatedProductFeatures != null ?
                ResponseEntity.status(201).body(updatedProductFeatures) :
                ResponseEntity.status(400).body(new GlobalError((short) 400, "Product feature not updated"));
    }

    @GetMapping("productFeature/{id}")
    public ResponseEntity<?> findProductFeatureById(@PathVariable Long id) {
        ProductFeatures productFeatures = productFeatureService.findProductFeatureById(id);
        return productFeatures != null ?
                ResponseEntity.status(200).body(productFeatures) :
                ResponseEntity.status(404).body(new GlobalError((short) 404,"Product feature not found"));
    }

    @GetMapping("productFeature/all")
    public ResponseEntity<?> findAllProductFeatures(@RequestParam int page,@RequestParam int size) {
        Page<ProductFeatures> productFeaturesPage = productFeatureService.findAllProductFeatures(page,size);
        return ResponseEntity.status(200).body(productFeaturesPage);
    }

    @GetMapping("productFeature/price")
    public ResponseEntity<?> findProductByPrice(@RequestParam double salePriceGreater,@RequestParam double salePriceLess,@RequestParam int page,@RequestParam int size) {
        Page<ProductFeatures> productFeaturesPage = productFeatureService.findProductsByPrice(salePriceGreater,salePriceLess,page,size);
        return ResponseEntity.status(200).body(productFeaturesPage);
    }

    @GetMapping("productFeature/product")
    public ResponseEntity<?> findFeatureByProductID(@RequestParam Long id,@RequestParam int page,@RequestParam int size) {
        Page<ProductFeatures> productFeaturesPage = productFeatureService.findFeaturesByProductId(id,page,size);
        return ResponseEntity.status(200).body(productFeaturesPage);
    }

    @GetMapping("productFeature/availability")
    public ResponseEntity<?> findFeatureAvailability(@RequestParam String availability,@RequestParam int page,@RequestParam int size) {
        Page<ProductFeatures> productFeaturesPage = productFeatureService.findFeaturesAvailability(availability,page,size);
        return ResponseEntity.status(200).body(productFeaturesPage);
    }

    @GetMapping("productFeature/dosageForm")
    public ResponseEntity<?> findFeatureByDosageForm(@RequestParam String dosageForm,@RequestParam int page,@RequestParam int size) {
        Page<ProductFeatures> productFeaturesPage = productFeatureService.findFeaturesByDosageForm(dosageForm,page,size);
        return ResponseEntity.status(200).body(productFeaturesPage);
    }
}
