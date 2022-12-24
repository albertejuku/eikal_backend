package com.eikal.repository.store.inventory;


import com.eikal.models.store.inventory.Manufacturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author David Kinyanjui
 */

@Repository
public interface ManufacturerRepo extends JpaRepository<Manufacturer, Long> {
    Page<Manufacturer> findByBusinessCategory(String businessCategory, Pageable pageable);

    Page<Manufacturer> findByLocation(String location, Pageable pageable);




}
