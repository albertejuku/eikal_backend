package com.eikal.controller.store.inventory;

import com.eikal.models.store.inventory.Price;
import com.eikal.service.store.inventory.PriceService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author David Kinyanjui
 */

@RestController
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @PostMapping("price/add")
    public ResponseEntity<?> addPrice(@RequestBody Price price) {
        Price addedPrice = priceService.addPrice(price);
        return addedPrice != null ?
                ResponseEntity.status(201).body(addedPrice) :
                ResponseEntity.status(415).build();
    }

    @PutMapping("price/update")
    public ResponseEntity<?> updatePrice(@RequestBody Price price,@RequestParam Long Id) {
        Price updatedPrice = priceService.updatePrice(price,Id);
        return updatedPrice != null ?
                ResponseEntity.ok().body(updatedPrice) :
                ResponseEntity.status(415).build();
    }

    @GetMapping("price/currency")
    public ResponseEntity<?> findPriceByCurrency(@RequestParam String currency,@RequestParam int page,@RequestParam int size) {
        Page<Price> pricePage = priceService.findPriceByCurrency(currency,page,size);
        return !pricePage.isEmpty() ?
                ResponseEntity.ok().body(pricePage) :
                ResponseEntity.notFound().build();
    }

    @GetMapping("price/discount")
    public ResponseEntity<?> findPriceByDiscount(@RequestParam double discount,@RequestParam int page,@RequestParam int size) {
        Page<Price> pricePage = priceService.findPriceByDiscount(discount,page,size);
        return !pricePage.isEmpty() ?
                ResponseEntity.status(200).body(pricePage) :
                ResponseEntity.notFound().build();
    }
}
