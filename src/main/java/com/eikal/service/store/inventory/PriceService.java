package com.eikal.service.store.inventory;


import com.eikal.models.store.inventory.Price;
import com.eikal.repository.store.inventory.PriceRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author  David Kinyanjui
 */
@Service
public class PriceService {

    private final PriceRepo priceRepo;

    public PriceService(PriceRepo priceRepo) {
        this.priceRepo = priceRepo;
    }

    public Price addPrice(Price price) {
        return priceRepo.save(price);
    }

    public Price updatePrice(Price price,Long Id) {
        price.setId(Id);
        return priceRepo.save(price);
    }

    public void deletePrice(Long id) {
        priceRepo.deleteById(id);
    }

    public Page<Price> findPriceByCurrency(String currency, int page,int size) {
        return priceRepo.findByCurrency(currency, PageRequest.of(page,size));
    }

    public Page<Price> findPriceByDiscount(double discount, int page,int size) {
        return priceRepo.findByDiscount(discount, PageRequest.of(page,size));
    }

}
