package com.eikal.repository.store.inventory;

import com.eikal.models.store.inventory.ItemCategory;
import com.eikal.models.store.inventory.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *@author David Kinyanjui
 */
@Repository
public interface ProductImageRepo extends JpaRepository<ProductImage, Long> {
}