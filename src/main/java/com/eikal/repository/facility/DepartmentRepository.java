package com.eikal.repository.facility;

import com.eikal.models.facility.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findAllByFacility_Id(Long facilityId);

}
