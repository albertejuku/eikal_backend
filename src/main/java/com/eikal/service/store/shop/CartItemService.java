package com.eikal.service.store.shop;

import com.eikal.models.store.shop.CartItem;
import com.eikal.repository.store.shop.CartItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author David Kinyanjui
 */

@Service
public class CartItemService {

    @Autowired
    private CartItemRepo cartItemRepo;

    public void addCartItem(CartItem cartItem) {
        cartItemRepo.save(cartItem);
    }

    public CartItem updateCartItem(CartItem cartItem, Long Id) {
        cartItem.setId(Id);
        return cartItemRepo.save(cartItem);
    }

    public void deleteCartItem(Long Id) {
        cartItemRepo.deleteById(Id);
    }

    public CartItem findCartItemById(Long Id) {
        return cartItemRepo.findById(Id).orElse(null);
    }

    public List<CartItem> findAllCartItems() {
        return cartItemRepo.findAll();
    }

    public List<CartItem> findByEmail(String email) {

        return cartItemRepo.findByCart_Email(email);
    }
}
