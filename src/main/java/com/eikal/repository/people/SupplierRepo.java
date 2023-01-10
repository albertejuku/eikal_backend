package com.eikal.repository.people;

import com.eikal.models.people.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author David Kinyanjui
 */

@Repository
public interface SupplierRepo extends JpaRepository<Supplier,Long> {
}
