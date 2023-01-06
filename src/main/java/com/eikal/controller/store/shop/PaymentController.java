package com.eikal.controller.store.shop;

import com.eikal.error.GlobalError;
import com.eikal.models.store.shop.Payment;
import com.eikal.service.store.shop.PaymentService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author David Kinyanjui
 */

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("payment/add")
    public ResponseEntity<?> addPayment(@RequestBody Payment payment) {
        Payment addedPayment = paymentService.addPayment(payment);
        return addedPayment != null ?
                ResponseEntity.status(201).body(addedPayment) :
                ResponseEntity.status(400).body(new GlobalError((short) 400, "Not added"));
    }

    @PutMapping("payment/update")
    public ResponseEntity<?> updatePayment(@RequestBody Payment payment,@RequestParam Long id){
        Payment updatedPayment = paymentService.updatePayment(payment,id);
        return updatedPayment != null ?
                ResponseEntity.status(201).body(updatedPayment) :
                ResponseEntity.status(400).body(new GlobalError((short) 400,"Not updated"));
    }

    @GetMapping("payment/all")
    public ResponseEntity<?> findAllPayments(@RequestParam int page,@RequestParam int size) {
        Page<Payment> paymentPage = paymentService.findAllPayments(page,size);
        return ResponseEntity.status(200).body(paymentPage);
    }

    @GetMapping("payment/orderQuantity")
    public ResponseEntity<?> findByOrderQuantity(@RequestParam int quantity,@RequestParam int page,@RequestParam int size) {
        Page<Payment> paymentPage = paymentService.findByOrderQuantity(quantity,page,size);
        return ResponseEntity.status(200).body(paymentPage);
    }

    @GetMapping("payment/orderCode")
    public ResponseEntity<?> findByOrderCode(@RequestParam String code) {
        Payment payment = paymentService.findByOrderCode(code);
        return payment != null ?
                ResponseEntity.status(200).body(payment) :
                ResponseEntity.status(404).body(new GlobalError((short) 404,"Not found"));
    }

    @GetMapping("payment/customerEmail")
    public ResponseEntity<?> findByOrderCustomerEmail(@RequestParam String email,@RequestParam int page,@RequestParam int size) {
        Page<Payment> paymentPage = paymentService.findByOrderCustomerEmail(email,page,size);
        return ResponseEntity.status(200).body(paymentPage);
    }

    @GetMapping("payment/deliveryAddress")
    public ResponseEntity<?> findByOrderDeliveryAddress(@RequestParam String address,@RequestParam int page,@RequestParam int size) {
        Page<Payment> paymentPage = paymentService.findByOrderDeliveryAddress(address,page,size);
        return ResponseEntity.status(200).body(paymentPage);
    }

    @GetMapping("payment/status")
    public ResponseEntity<?> findByStatus(@RequestParam String status,@RequestParam int page,@RequestParam int size) {
        Page<Payment> paymentPage = paymentService.findByStatus(status,page,size);
        return ResponseEntity.status(200).body(paymentPage);
    }
}
