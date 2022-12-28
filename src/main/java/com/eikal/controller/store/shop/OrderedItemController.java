package com.eikal.controller.store.shop;

import com.eikal.error.GlobalError;
import com.eikal.models.store.shop.OrderedItem;
import com.eikal.service.store.shop.OrderedItemService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author David Kinyanjui
 */

@RestController
public class OrderedItemController {

    private final OrderedItemService orderedItemService;

    public OrderedItemController(OrderedItemService orderedItemService) {
        this.orderedItemService = orderedItemService;
    }

    @PostMapping("orderedItem/add")
    public ResponseEntity<?> addOrderedItem(@RequestBody OrderedItem orderedItem) {
        OrderedItem addedOrderedItem = orderedItemService.addOrderedItem(orderedItem);
        return addedOrderedItem != null ?
                ResponseEntity.status(201).body(addedOrderedItem) :
                ResponseEntity.status(400).body(new GlobalError((short) 400,"Ordered item not added"));
    }

    @PutMapping("orderedItem/update")
    public ResponseEntity<?> updateOrderedItem(@RequestBody OrderedItem orderedItem,@RequestParam Long id) {
        OrderedItem updatedOrderedItem = orderedItemService.updateOrderedItem(orderedItem,id);
        return updatedOrderedItem != null ?
                ResponseEntity.status(201).body(updatedOrderedItem) :
                ResponseEntity.status(400).body(new GlobalError((short) 400,"Ordered item not updated"));
    }

    @GetMapping("orderedItem/{id}")
    public ResponseEntity<?> findOrderedItemById(@PathVariable Long id) {
        OrderedItem orderedItem = orderedItemService.findOrderedItemById(id);
        return orderedItem != null ?
                ResponseEntity.status(200).body(orderedItem) :
                ResponseEntity.status(404).body(new GlobalError((short) 404,"Ordered item not found"));
    }

    @GetMapping("orderedItem/all")
    public ResponseEntity<?> findAllOrderedItem(@RequestParam int page,@RequestParam int size) {
        Page<OrderedItem> orderedItemPage = orderedItemService.findAllOrderedItems(page,size);
        return ResponseEntity.status(200).body(orderedItemPage);
    }

    @GetMapping("orderedItem/salePrice")
    public ResponseEntity<?> findBySalePrice(@RequestParam double salePrice,@RequestParam int page,int size) {
        Page<OrderedItem> orderedItemPage = orderedItemService.findBySalePrice(salePrice,page,size);
        return ResponseEntity.status(200).body(orderedItemPage);
    }

    @GetMapping("orderedItem/quantity")
    public ResponseEntity<?> findByQuantity(@RequestParam int quantity,@RequestParam int page,@RequestParam int size){
        Page<OrderedItem> orderedItemPage = orderedItemService.findByQuantity(quantity,page,size);
        return ResponseEntity.status(200).body(orderedItemPage);
    }
}
