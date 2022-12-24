package com.eikal.repository.store.inventory;

import com.eikal.models.store.inventory.ItemCategory;
import com.eikal.models.store.inventory.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@author David Kinyanjui
 */
@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    Page<Product> findAllByCategoryOrderByNameAsc(String category, Pageable page);
    Product findByItemCode(String itemCode);
    Page<Product> findAllByManufacturer_Id(Long Id, Pageable page);

    Page<Product> findByTax_Type(String type, Pageable pageable);

    Page<Product> findByTax_Amount(double amount, Pageable pageable);

}
