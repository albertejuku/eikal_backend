package com.eikal.service.places;

import com.eikal.models.places.Address;
import com.eikal.repository.places.AddressRepository;
import org.springframework.stereotype.Service;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address save(Address address) {
        return addressRepository.save(address);
    }
}
