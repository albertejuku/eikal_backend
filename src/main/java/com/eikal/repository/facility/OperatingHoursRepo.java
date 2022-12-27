package com.eikal.repository.facility;

import com.eikal.models.facility.OperatingHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author David Kinyanjui
 */

@Repository
public interface OperatingHoursRepo extends JpaRepository<OperatingHours,Long> {
}
