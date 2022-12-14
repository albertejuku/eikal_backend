package com.eikal.service.store.shop;

import com.eikal.models.store.shop.OrderedItem;
import com.eikal.repository.store.shop.OrderedItemRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author David Kinyanjui
 */

@Service
public class OrderedItemService {


    private final OrderedItemRepo orderedItemRepo;

    public OrderedItemService(OrderedItemRepo orderedItemRepo) {
        this.orderedItemRepo = orderedItemRepo;
    }

    public OrderedItem addOrderedItem(OrderedItem orderedItem) {
        return orderedItemRepo.save(orderedItem);
    }

    public OrderedItem updateOrderedItem(OrderedItem orderedItem, Long id) {
        orderedItem.setId(id);
        return orderedItemRepo.save(orderedItem);
    }

    public void deleteOrderedItem(Long id) {
        orderedItemRepo.deleteById(id);
    }

    public OrderedItem findOrderedItemById(Long id) {
        return orderedItemRepo.findById(id).orElse(null);
    }

    public Page<OrderedItem> findAllOrderedItems(int page,int size) {
        return orderedItemRepo.findAll(PageRequest.of(page,size));
    }

    public Page<OrderedItem> findBySalePrice(double salePrice,int page,int size) {
        return orderedItemRepo.findBySalePrice(salePrice,PageRequest.of(page,size));
    }

    public Page<OrderedItem> findByQuantity(int quantity,int page,int size) {
        return orderedItemRepo.findByQuantity(quantity,PageRequest.of(page,size));
    }


}
