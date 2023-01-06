package com.eikal.repository.appointments;

import com.eikal.models.appointments.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author David Kinyanjui
 */

@Repository
public interface AppointmentsRepo extends JpaRepository<Appointment,Long> {
    List<Appointment> findByCreatedBy_Email(String email);

    List<Appointment> findByModifiedBy_Email(String email);

    Page<Appointment> findByCreatedBy_Id(Long id, Pageable pageable);

    Page<Appointment> findByModifiedBy_Id(Long id, Pageable pageable);

    Page<Appointment> findByCreatedBy_Username(String username, Pageable pageable);

    Page<Appointment> findByModifiedBy_Username(String username, Pageable pageable);

    Page<Appointment> findByDuration(int duration, Pageable pageable);

    Page<Appointment> findByStatus(String status, Pageable pageable);

    Page<Appointment> findByType(String type, Pageable pageable);

    List<Appointment> findByPatient_NationalId(Long nationalId);

    List<Appointment> findByPatient_Id(Long id);

    Page<Appointment> findByMedicalPractitioner_Id(Long id, Pageable pageable);

    Page<Appointment> findByMedicalPractitioner_Title(String title, Pageable pageable);

    Page<Appointment> findByDepartment_Name(String name, Pageable pageable);

    Page<Appointment> findByDepartment_Id(Long id, Pageable pageable);

}
