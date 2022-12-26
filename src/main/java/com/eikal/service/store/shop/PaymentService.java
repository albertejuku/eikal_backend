package com.eikal.service.store.shop;

import com.eikal.models.store.shop.Payment;
import com.eikal.repository.store.shop.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author David Kinyanjui
 */

@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    public Payment addPayment(Payment payment) {
        return paymentRepo.save(payment);
    }

    public Payment updatePayment(Payment payment,Long Id) {
        payment.setId(Id);
        return paymentRepo.save(payment);
    }

    public void deletePayment(Long Id) {
        paymentRepo.deleteById(Id);
    }

    public Page<Payment> findAllPayments(int page,int size) {
        return paymentRepo.findAll(PageRequest.of(page,size));
    }

    public Page<Payment> findByOrderQuantity(int quantity,int page,int size) {
        return paymentRepo.findByOrder_Quantity(quantity,PageRequest.of(page,size));
    }

    public Payment findByOrderCode(String code) {
        return paymentRepo.findByOrder_Code(code);
    }

    public Page<Payment> findByOrderCustomerEmail(String email,int page,int size) {
        return paymentRepo.findByOrder_Customer_Email(email,PageRequest.of(page,size));
    }

    public Page<Payment> findByOrderDeliveryAddress(String address,int page,int size) {
        return paymentRepo.findByOrder_DeliveryAddress_Address(address,PageRequest.of(page,size));
    }

    public Page<Payment> findByStatus(String status,int page,int size) {
        return paymentRepo.findByStatus(status,PageRequest.of(page,size));
    }

}
