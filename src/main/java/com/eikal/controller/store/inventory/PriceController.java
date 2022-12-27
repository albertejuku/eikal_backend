package com.eikal.controller.store.inventory;

import com.eikal.error.GlobalError;
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
                ResponseEntity.status(400).body(new GlobalError((short) 400,"Price not added"));
    }

    @PutMapping("price/update")
    public ResponseEntity<?> updatePrice(@RequestBody Price price,@RequestParam Long Id) {
        Price updatedPrice = priceService.updatePrice(price,Id);
        return updatedPrice != null ?
                ResponseEntity.status(201).body(updatedPrice) :
                ResponseEntity.status(400).body(new GlobalError((short) 400,"Price not updated"));
    }

    @GetMapping("price/currency")
    public ResponseEntity<?> findPriceByCurrency(@RequestParam String currency,@RequestParam int page,@RequestParam int size) {
        Page<Price> pricePage = priceService.findPriceByCurrency(currency,page,size);
        return ResponseEntity.ok().body(pricePage);
    }

    @GetMapping("price/discount")
    public ResponseEntity<?> findPriceByDiscount(@RequestParam double discount,@RequestParam int page,@RequestParam int size) {
        Page<Price> pricePage = priceService.findPriceByDiscount(discount,page,size);
        return ResponseEntity.status(200).body(pricePage);
    }
}
