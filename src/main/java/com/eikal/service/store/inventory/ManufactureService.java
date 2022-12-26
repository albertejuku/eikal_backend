package com.eikal.service.store.inventory;


import com.eikal.models.store.inventory.Manufacturer;
import com.eikal.repository.store.inventory.ManufacturerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author David Kinyanjui
 */

@Service
public class ManufactureService {

    @Autowired
    private ManufacturerRepo manufacturerRepo;

    public Manufacturer addManufacture(Manufacturer manufacturer) {
        return manufacturerRepo.save(manufacturer);
    }

    public Manufacturer updateManufacturer(Manufacturer manufacturer, Long Id) {
        manufacturer.setId(Id);
        return manufacturerRepo.save(manufacturer);
    }

    public Page<Manufacturer> findBusinessCategory(String business,int page,int size) {
        return manufacturerRepo.findByBusinessCategory(business, PageRequest.of(page,size));
    }

    public Page<Manufacturer> findLocation(String location,int page,int size) {
        return manufacturerRepo.findByLocation(location, PageRequest.of(page,size));
    }

    public void deleteManufacturer(Long Id) {
        manufacturerRepo.deleteById(Id);
    }
}
