package com.eikal.service.store.inventory;

import com.eikal.models.store.inventory.ItemCategory;
import com.eikal.repository.store.inventory.ItemCategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author David Kinyanjui
 */
@Service
public class ItemCategoryService {

    private final ItemCategoryRepo itemCategoryRepo;

    public ItemCategoryService(ItemCategoryRepo itemCategoryRepo) {
        this.itemCategoryRepo = itemCategoryRepo;
    }

    public ItemCategory addCategory(ItemCategory itemCategory) {
        return itemCategoryRepo.save(itemCategory);
    }

    public ItemCategory updateCategory(ItemCategory itemCategory, Long id) {
        itemCategory.setId(id);
        return itemCategoryRepo.save(itemCategory);
    }

    public void deleteCategory(Long id) {
        itemCategoryRepo.deleteById(id);
    }

    public ItemCategory findCategoryById(Long id) {
        return itemCategoryRepo.findById(id).orElse(null);
    }

    public List<ItemCategory> findAllCategories() {
        return itemCategoryRepo.findAll();
    }



}
