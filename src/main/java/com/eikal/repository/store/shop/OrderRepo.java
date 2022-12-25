package com.eikal.repository.store.shop;

import com.eikal.models.store.shop.Order_;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author David Kinyanjui
 */

@Repository
public interface OrderRepo extends JpaRepository<Order_,Long> {
    Page<Order_> findByOrderAmount(double orderAmount, Pageable pageable);

    Order_ findByCode(String code);

    Page<Order_> findByCustomer_Email(String email, Pageable pageable);

    Page<Order_> findByDeliveryAddress_Address_(String address_, Pageable pageable);


}
