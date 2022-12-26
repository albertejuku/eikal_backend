package com.eikal.repository.store.inventory;

import com.eikal.models.store.inventory.ItemCategory;
import com.eikal.models.store.inventory.Tax;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *@author David Kinyanjui
 */
@Repository
public interface TaxRepo extends JpaRepository<Tax, Long> {
    Page<Tax> findByType(String type, Pageable pageable);


}
