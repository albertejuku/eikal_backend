package com.eikal.service.store.inventory;

import com.eikal.repository.store.inventory.ItemCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemCategoryService {

    @Autowired
    private ItemCategoryRepo itemCategoryRepo;


}
