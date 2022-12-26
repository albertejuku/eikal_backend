package com.eikal.service.store.inventory;


import com.eikal.models.store.inventory.Tax;
import com.eikal.repository.store.inventory.TaxRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author David Kinyanjui
 */
@Service
public class TaxService {

    @Autowired
    private TaxRepo taxRepo;

    public Tax addTax(Tax tax) {
        return taxRepo.save(tax);
    }

    public Tax updateTax(Tax tax, Long Id) {
        tax.setId(Id);
        return taxRepo.save(tax);
    }

    public void deleteTax(Long Id) {
        taxRepo.deleteById(Id);
    }

    public Page<Tax> findType(String type,int page,int size) {
        return taxRepo.findByType(type, PageRequest.of(page,size));
    }

}
