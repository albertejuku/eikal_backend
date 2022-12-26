package com.eikal.service.store.inventory;

import com.eikal.models.store.inventory.ItemCategory;
import com.eikal.repository.store.inventory.ItemCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author David Kinyanjui
 */
@Service
public class ItemCategoryService {

    @Autowired
    private ItemCategoryRepo itemCategoryRepo;

    public ItemCategory addCategory(ItemCategory itemCategory) {
        return itemCategoryRepo.save(itemCategory);
    }

    public ItemCategory updateCategory(ItemCategory itemCategory, Long Id) {
        itemCategory.setId(Id);
        return itemCategoryRepo.save(itemCategory);
    }

    public void deleteCategory(Long Id) {
        itemCategoryRepo.deleteById(Id);
    }

    public ItemCategory findCategoryById(Long Id) {
        return itemCategoryRepo.findById(Id).orElse(null);
    }

    public List<ItemCategory> findAllCategories() {
        return itemCategoryRepo.findAll();
    }



}
