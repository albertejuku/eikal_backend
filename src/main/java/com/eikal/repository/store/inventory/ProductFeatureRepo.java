package com.eikal.repository.store.inventory;

import com.eikal.models.store.inventory.ItemCategory;
import com.eikal.models.store.inventory.ProductFeatures;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *@author David Kinyanjui
 */
@Repository
public interface ProductFeatureRepo extends JpaRepository<ProductFeatures, Long> {

    Page<ProductFeatures> findByPrice_SalePriceGreaterThanEqualAndPrice_SalePriceLessThanOrderByPrice_SalePriceDesc(double salePriceGreater, double salePriceLess, Pageable pageable);

    Page<ProductFeatures> findByProduct_Id(Long id, Pageable pageable);

    Page<ProductFeatures> findByAvailability(String availability, Pageable page);

    Page<ProductFeatures> findByDosageForm(String dosageForm, Pageable pageable);

}
