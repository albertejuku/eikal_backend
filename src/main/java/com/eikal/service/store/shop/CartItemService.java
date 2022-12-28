package com.eikal.service.store.shop;

import com.eikal.models.store.shop.CartItem;
import com.eikal.repository.store.shop.CartItemRepo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author David Kinyanjui
 */

@Service
public class CartItemService {


    private final CartItemRepo cartItemRepo;

    public CartItemService(CartItemRepo cartItemRepo) {
        this.cartItemRepo = cartItemRepo;
    }

    public CartItem addCartItem(CartItem cartItem) {
        return cartItemRepo.save(cartItem);
    }

    public CartItem updateCartItem(CartItem cartItem, Long id) {
        cartItem.setId(id);
        return cartItemRepo.save(cartItem);
    }

    public void deleteCartItem(Long id) {
        cartItemRepo.deleteById(id);
    }

    public CartItem findCartItemById(Long id) {
        return cartItemRepo.findById(id).orElse(null);
    }

    public List<CartItem> findAllCartItems() {
        return cartItemRepo.findAll();
    }

    public List<CartItem> findByEmail(String email) {

        return cartItemRepo.findByCart_Email(email);
    }
}
