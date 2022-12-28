package com.eikal.controller.store.shop;

import com.eikal.error.GlobalError;
import com.eikal.models.store.shop.CartItem;
import com.eikal.service.store.shop.CartItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author David Kinyanjui
 */

@RestController
public class CartItemController {

    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping("cartItem/add")
    public ResponseEntity<?> addCartItem(@RequestBody CartItem cartItem) {
        CartItem addedCartItem = cartItemService.addCartItem(cartItem);
        return addedCartItem != null ?
                ResponseEntity.status(201).body(addedCartItem) :
                ResponseEntity.status(400).body(new GlobalError((short) 400,"Cart item not added"));
    }

    @PutMapping("cartItem/update")
    public ResponseEntity<?> updateCartItem(@RequestBody CartItem cartItem,@RequestParam Long id) {
        CartItem updatedCartItem = cartItemService.updateCartItem(cartItem,id);
        return updatedCartItem != null ?
                ResponseEntity.status(201).body(updatedCartItem) :
                ResponseEntity.status(400).body(new GlobalError((short) 400,"Cart item not updated"));
    }

    @GetMapping("cartItem/{id}")
    public ResponseEntity<?> findCartItemById(@PathVariable Long id) {
        CartItem cartItem = cartItemService.findCartItemById(id);
        return cartItem != null ?
                ResponseEntity.status(200).body(cartItem) :
                ResponseEntity.status(404).body(new GlobalError((short) 404,"Cart item not found"));
    }

    @GetMapping("cartItem/all")
    public ResponseEntity<?> findAllCartItems() {
        List<CartItem> cartItems = cartItemService.findAllCartItems();
        return !cartItems.isEmpty() ?
                ResponseEntity.status(200).body(cartItems) :
                ResponseEntity.status(404).body(new GlobalError((short) 404, "cartItems not found"));
    }

    @GetMapping("cartItem/email")
    public ResponseEntity<?> findByEmail(@RequestParam String email) {
        List<CartItem> cartItems = cartItemService.findByEmail(email);
        return !cartItems.isEmpty() ?
                ResponseEntity.status(200).body(cartItems) :
                ResponseEntity.status(404).body(new GlobalError((short) 404, "Cart item not found"));
    }
}
