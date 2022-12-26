package com.eikal.repository.store.shop;

import com.eikal.models.store.shop.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author David Kinyanjui
 */

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Long> {
    Page<Payment> findByOrder_Quantity(int quantity, Pageable pageable);

    Payment findByOrder_Code(String code);

    Page<Payment> findByOrder_Customer_Email(String email, Pageable pageable);

    Page<Payment> findByOrder_DeliveryAddress_Address(String address, Pageable pageable);

    Page<Payment> findByStatus(String status, Pageable pageable);


}
