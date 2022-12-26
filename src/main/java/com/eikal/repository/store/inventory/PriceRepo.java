package com.eikal.repository.store.inventory;

import com.eikal.models.store.inventory.ItemCategory;
import com.eikal.models.store.inventory.Price;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *@author David Kinyanjui
 */

@Repository
public interface PriceRepo extends JpaRepository<Price, Long> {
    Page<Price> findByCurrency(String currency, Pageable pageable);

    Page<Price> findByDiscount(double discount, Pageable pageable);




}
