package com.eikal.controller.store.inventory;

import com.eikal.models.store.inventory.ItemCategory;
import com.eikal.service.store.inventory.ItemCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author David Kinyanjui
 */

@RestController
public class ItemCategoryController {

    private final ItemCategoryService itemCategoryService;

    public ItemCategoryController(ItemCategoryService itemCategoryService) {
        this.itemCategoryService = itemCategoryService;
    }

    @PostMapping("itemCategory/add")
    public ResponseEntity<?> addItemCategory(@RequestBody ItemCategory itemCategory) {
        ItemCategory addedItemCategory = itemCategoryService.addCategory(itemCategory);
        return addedItemCategory != null ?
                ResponseEntity.status(201).body(addedItemCategory) :
                ResponseEntity.status(415).build();
    }

    @GetMapping("itemCategory/{id}")
    public ResponseEntity<?> findCategory(@PathVariable Long Id) {
        ItemCategory category = itemCategoryService.findCategoryById(Id);
        return category != null ?
                ResponseEntity.status(200).body(category) :
                ResponseEntity.status(404).body("did not found category");
    }


}
