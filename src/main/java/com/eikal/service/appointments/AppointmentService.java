package com.eikal.service.appointments;

import com.eikal.models.appointments.Appointment;
import com.eikal.repository.appointments.AppointmentsRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author David Kinyanjui
 */

@Service
public class AppointmentService {

    private final AppointmentsRepo appointmentsRepo;

    public AppointmentService(AppointmentsRepo appointmentsRepo) {
        this.appointmentsRepo = appointmentsRepo;
    }


    public Appointment addAppointment(Appointment appointment) {
        return appointmentsRepo.save(appointment);
    }

    public Appointment updateAppointment(Appointment appointment,Long id) {
        appointment.setId(id);
        return appointmentsRepo.save(appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentsRepo.deleteById(id);
    }

    public Page<Appointment> findAllAppointments(int page,int size) {
        return appointmentsRepo.findAll(PageRequest.of(page,size));
    }

    public Appointment findAppointmentById(Long id) {
        return appointmentsRepo.findById(id).orElse(null);
    }

    public List<Appointment> findByCreatedByEmail(String email) {
        return appointmentsRepo.findByCreatedBy_Email(email);
    }

    public List<Appointment> findByModifiedByEmail(String email) {
        return appointmentsRepo.findByModifiedBy_Email(email);
    }

    public Page<Appointment> findByCreatedById(Long id,int page,int size) {
        return appointmentsRepo.findByCreatedBy_Id(id,PageRequest.of(page,size));
    }

    public Page<Appointment> findByModifiedById(Long id,int page,int size) {
        return appointmentsRepo.findByModifiedBy_Id(id,PageRequest.of(page,size));
    }

    public Page<Appointment> findByCreatedByUsername(String username,int page,int size) {
        return appointmentsRepo.findByCreatedBy_Username(username,PageRequest.of(page,size));
    }

    public Page<Appointment> findByModifiedByUsername(String username,int page,int size) {
        return appointmentsRepo.findByModifiedBy_Username(username,PageRequest.of(page,size));
    }

    public Page<Appointment> findByDuration(int duration,int page,int size) {
        return appointmentsRepo.findByDuration(duration,PageRequest.of(page,size));
    }

    public Page<Appointment> findByStatus(String status,int page,int size) {
        return appointmentsRepo.findByStatus(status,PageRequest.of(page,size));
    }

    public Page<Appointment> findByType(String type,int page,int size){
        return appointmentsRepo.findByType(type,PageRequest.of(page,size));
    }

    public List<Appointment> findByPatientNationalId(Long nationalId) {
        return appointmentsRepo.findByPatient_NationalId(nationalId);
    }

    public List<Appointment> findByPatientId(Long id) {
        return appointmentsRepo.findByPatient_Id(id);
    }

    public Page<Appointment> findByMedicalPractitionerId(Long id,int page,int size){
        return appointmentsRepo.findByMedicalPractitioner_Id(id,PageRequest.of(page,size));
    }

    public Page<Appointment> findByMedicalPractitionerTitle(String title,int page,int size){
        return appointmentsRepo.findByMedicalPractitioner_Title(title,PageRequest.of(page,size));
    }

    public Page<Appointment> findByDepartmentName(String name,int page,int size){
        return appointmentsRepo.findByDepartment_Name(name,PageRequest.of(page,size));
    }

    public Page<Appointment> findByDepartmentId(Long id,int page,int size){
        return appointmentsRepo.findByDepartment_Id(id,PageRequest.of(page,size));
    }
}
