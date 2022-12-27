package com.eikal.controller.store.inventory;


import com.eikal.models.store.inventory.Manufacturer;
import com.eikal.service.store.inventory.ManufactureService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author David Kinyanjui
 */

@RestController
public class ManufacturerController {

    private final ManufactureService manufactureService;

    public ManufacturerController(ManufactureService manufactureService) {
        this.manufactureService = manufactureService;
    }

    @PostMapping("manufacturer/add")
    public ResponseEntity<?> addManufacturer(@RequestBody Manufacturer manufacturer) {
        Manufacturer addedManufacturer = manufactureService.addManufacture(manufacturer);
        return addedManufacturer != null ?
           ResponseEntity.status(201).body(addedManufacturer) :
           ResponseEntity.status(415).build();
    }

    @PutMapping("manufacturer/update")
    public ResponseEntity<?> updateManufacturer(@RequestBody Manufacturer manufacturer, @RequestParam Long Id) {
        Manufacturer updatedManufacture = manufactureService.updateManufacturer(manufacturer,Id);
        return updatedManufacture != null ?
                ResponseEntity.ok().body(updatedManufacture) :
                ResponseEntity.status(415).build();
    }

    @GetMapping("manufacturer/businessCategory")
    public ResponseEntity<?> findBusinessCategory(@RequestParam String business,@RequestParam int page,@RequestParam int size) {
        Page<Manufacturer> manufacturerPage = manufactureService.findBusinessCategory(business,page,size);
        return ResponseEntity.status(200).body(manufacturerPage);
    }

    @GetMapping("manufacturer/location")
    public ResponseEntity<?> findLocation(@RequestParam String location,@RequestParam int page,@RequestParam int size) {
        Page<Manufacturer> manufacturerPage = manufactureService.findLocation(location,page,size);
        return ResponseEntity.status(200).body(manufacturerPage);
    }
}
