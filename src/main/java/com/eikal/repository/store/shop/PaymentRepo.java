package com.eikal.repository.store.shop;

import com.eikal.models.store.shop.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author David Kinyanjui
 */

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Long> {
}
