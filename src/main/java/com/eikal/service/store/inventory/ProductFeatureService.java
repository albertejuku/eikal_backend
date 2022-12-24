package com.eikal.service.store.inventory;


import com.eikal.models.store.inventory.ProductFeatures;
import com.eikal.repository.store.inventory.ProductFeatureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author David Kinyanjui
 */
@Service
public class ProductFeatureService {

    @Autowired
    private ProductFeatureRepo productFeatureRepo;

    public void addProductFeature(ProductFeatures productFeatures) {
        productFeatureRepo.save(productFeatures);
    }

    public ProductFeatures updateProductFeature(ProductFeatures productFeatures, Long Id) {
        productFeatures.setId(Id);
        return productFeatureRepo.save(productFeatures);
    }

    public void deleteProductFeatureById(Long Id) {
        productFeatureRepo.deleteById(Id);
    }

    public ProductFeatures findProductFeatureById(Long Id) {
        return productFeatureRepo.findById(Id).orElse(null);
    }

    public Page<ProductFeatures> findAllProductFeatures(int page,int size) {
        return productFeatureRepo.findAll(PageRequest.of(page,size));
    }

    public Page<ProductFeatures> findProductsByPrice(double salePriceGreater, double salePriceLess,int page,int size ) {
        return productFeatureRepo.findByPrice_SalePriceGreaterThanEqualAndPrice_SalePriceLessThanOrderByPrice_SalePriceDesc(salePriceGreater,salePriceLess, PageRequest.of(page,size));
    }

    public Page<ProductFeatures> findFeaturesByProductId(Long Id, int page,int size) {
        return productFeatureRepo.findByProduct_Id(Id, PageRequest.of(page,size));
    }

    public Page<ProductFeatures> findFeaturesAvailability(String availability,int page,int size) {
        return productFeatureRepo.findByAvailability(availability, PageRequest.of(page,size));
    }

    public Page<ProductFeatures> findFeaturesByDosageForm(String dosageForm, int page,int size) {
        return productFeatureRepo.findByDosageForm(dosageForm, PageRequest.of(page,size));
    }

}
