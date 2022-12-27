package com.eikal.controller.store.inventory;


import com.eikal.error.GlobalError;
import com.eikal.models.store.inventory.Tax;
import com.eikal.service.store.inventory.TaxService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author David Kinyanjui
 */

@RestController
public class TaxController {

    private final TaxService taxService;

    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    @PostMapping("tax/add")
    public ResponseEntity<?> addTax(@RequestBody Tax tax) {
        Tax addedTax = taxService.addTax(tax);
        return addedTax != null ?
                ResponseEntity.status(201).body(addedTax) :
                ResponseEntity.status(400).body(new GlobalError((short) 400,"Tax was not added"));
    }

    @PutMapping("tax/update")
    public ResponseEntity<?> updateTax(Tax tax,Long id) {
        Tax updatedTax = taxService.updateTax(tax,id);
        return updatedTax != null ?
                ResponseEntity.status(201).body(updatedTax) :
                ResponseEntity.status(400).body(new GlobalError((short) 400,"Tax was not updated"));
    }

    @GetMapping("tax/type")
    public ResponseEntity<?> findType(@RequestParam String type,@RequestParam int page,@RequestParam int size) {
        Page<Tax> taxPage = taxService.findType(type,page,size);
        return ResponseEntity.status(200).body(taxPage);
    }
}
