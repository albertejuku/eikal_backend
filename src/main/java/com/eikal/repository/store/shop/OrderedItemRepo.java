package com.eikal.repository.store.shop;


import com.eikal.models.store.shop.OrderedItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author David Kinyanjui
 */

@Repository
public interface OrderedItemRepo extends JpaRepository<OrderedItem,Long> {
    Page<OrderedItem> findBySalePrice(double salePrice, Pageable pageable);

    Page<OrderedItem> findByQuantity(int quantity, Pageable pageable);


}
