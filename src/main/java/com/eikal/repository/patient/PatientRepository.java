package com.eikal.repository.patient;

import com.eikal.models.patient.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findAllByFacility_IdOrderByDateCreatedDesc(Long facilityId, Pageable pageable);

    List<Patient> findAllByUser_NationalId(long nationalId);

    List<Patient> findAllByUser_BirthCertNoContaining(long birthCert);

    List<Patient> findAllByUser_PhoneContaining(String phone);

    List<Patient> findAllByUser_EmailContaining(String email);

    List<Patient> findAllByUser_UsernameContaining(String username);

}
