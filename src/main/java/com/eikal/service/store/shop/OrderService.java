package com.eikal.service.store.shop;


import com.eikal.models.store.shop.Order_;
import com.eikal.repository.store.shop.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author David Kinyanjui
 */

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;


    public Order_ addOrder(Order_ order) {
        return orderRepo.save(order);
    }

    public Order_ updateOrder(Order_ order,Long Id) {
        order.setId(Id);
        return orderRepo.save(order);
    }

    public void deleteOrder(Long Id) {
        orderRepo.deleteById(Id);
    }

    public Order_ findOrderById(Long Id) {
        return orderRepo.findById(Id).orElse(null);
    }

    public Page<Order_> findAllOrders(int page,int size) {
        return orderRepo.findAll(PageRequest.of(page,size));
    }

    public Page<Order_> findOrderByAmount(double orderAmount,int page,int size) {
        return orderRepo.findByOrderAmount(orderAmount,PageRequest.of(page,size));
    }

    public Order_ findByCode(String code) {
        return orderRepo.findByCode(code);
    }

    public Page<Order_> findByCustomer(String email,int page,int size) {
        return orderRepo.findByCustomer_Email(email,PageRequest.of(page,size));
    }

    public Page<Order_> findByDeliveryAddress_Address(String address,int page,int size) {
        return orderRepo.findByDeliveryAddress_Address_(address,PageRequest.of(page,size));
    }

}
