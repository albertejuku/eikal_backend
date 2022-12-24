package com.eikal.repository.store.inventory;

import com.eikal.models.store.inventory.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *@author David Kinyanjui
 */

@Repository
public interface ItemCategoryRepo extends JpaRepository<ItemCategory, Long> {
}
