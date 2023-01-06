package com.eikal.controller.store.inventory;

import com.eikal.error.GlobalError;
import com.eikal.models.store.inventory.ItemCategory;
import com.eikal.service.store.inventory.ItemCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
                ResponseEntity.status(400).body(new GlobalError((short) 400,"Item category not added"));
    }

    @GetMapping("itemCategory/{id}")
    public ResponseEntity<?> findCategory(@PathVariable Long Id) {
        ItemCategory category = itemCategoryService.findCategoryById(Id);
        return category != null ?
                ResponseEntity.status(200).body(category) :
                ResponseEntity.status(404).body(new GlobalError((short) 404,"did not found category"));
    }

    @PutMapping("itemCategory/update")
    public ResponseEntity<?> updateCategory(@RequestBody ItemCategory category,@RequestParam Long Id) {
        ItemCategory itemCategory = itemCategoryService.updateCategory(category,Id);
        return itemCategory != null ?
                ResponseEntity.status(201).body(itemCategory) :
                ResponseEntity.status(400).body(new GlobalError((short) 400,"Not updated"));
    }

    @GetMapping("itemCategories/all")
    public ResponseEntity<?> findAllCategories() {
        List<ItemCategory> itemCategories = itemCategoryService.findAllCategories();
        return !itemCategories.isEmpty() ?
                ResponseEntity.status(200).body(itemCategories) :
                ResponseEntity.status(404).body(new GlobalError((short) 404, "Not found"));
    }
}
