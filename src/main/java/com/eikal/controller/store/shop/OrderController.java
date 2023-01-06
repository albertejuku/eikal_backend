package com.eikal.controller.store.shop;

import com.eikal.error.GlobalError;
import com.eikal.models.store.shop.Order_;
import com.eikal.service.store.shop.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author David Kinyanjui
 */

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("order/add")
    public ResponseEntity<?> addOrder(@RequestBody Order_ order) {
        Order_ addedOrder = orderService.addOrder(order);
        return addedOrder != null ?
                ResponseEntity.status(201).body(addedOrder) :
                ResponseEntity.status(400).body(new GlobalError((short) 400,"Not added"));
    }

    @PutMapping("order/update")
    public ResponseEntity<?> updateOrder(@RequestBody Order_ order,@RequestParam Long id) {
        Order_ updatedOrder = orderService.updateOrder(order,id);
        return updatedOrder != null ?
                ResponseEntity.status(201).body(updatedOrder) :
                ResponseEntity.status(400).body(new GlobalError((short) 400, "Not updated"));
    }

    @GetMapping("order/{id}")
    public ResponseEntity<?> findOrderById(@PathVariable Long id) {
        Order_ order = orderService.findOrderById(id);
        return order != null ?
                ResponseEntity.status(200).body(order) :
                ResponseEntity.status(404).body(new GlobalError((short) 404, "Not found"));
    }

    @GetMapping("order/all")
    public ResponseEntity<?> findAllOrders(@RequestParam int page,@RequestParam int size) {
        Page<Order_> orderPage = orderService.findAllOrders(page,size);
        return ResponseEntity.status(200).body(orderPage);
    }

    @GetMapping("order/amount")
    public ResponseEntity<?> findOrderByAmount(@RequestParam double orderAmount,@RequestParam int page,@RequestParam int size) {
        Page<Order_> orderPage = orderService.findOrderByAmount(orderAmount,page,size);
        return ResponseEntity.status(200).body(orderPage);
    }

    @GetMapping("order/code")
    public ResponseEntity<?> findByCode(@RequestParam String code) {
        Order_ order = orderService.findByCode(code);
        return order != null ?
                ResponseEntity.status(200).body(order) :
                ResponseEntity.status(404).body(new GlobalError((short) 404,"Not found"));
    }

    @GetMapping("order/customer")
    public ResponseEntity<?> findByCustomerEmail(@RequestParam String email,@RequestParam int page,@RequestParam int size) {
        Page<Order_> orderPage = orderService.findByCustomer(email,page,size);
        return ResponseEntity.status(200).body(orderPage);
    }

    @GetMapping("order/address")
    public ResponseEntity<?> findByDeliveryAddress(@RequestParam String address,@RequestParam int page,@RequestParam int size) {
        Page<Order_> orderPage = orderService.findByDeliveryAddress_Address(address,page,size);
        return ResponseEntity.status(200).body(orderPage);
    }
}
