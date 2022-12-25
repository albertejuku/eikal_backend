package com.eikal.repository.store.shop;


import com.eikal.models.store.shop.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author David Kinyanjui
 */

@Repository
public interface CartItemRepo extends JpaRepository<CartItem,Long> {
    List<CartItem> findByCart_Email(String email);



}
