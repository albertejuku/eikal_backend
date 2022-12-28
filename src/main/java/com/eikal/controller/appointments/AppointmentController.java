package com.eikal.controller.appointments;


import com.eikal.error.GlobalError;
import com.eikal.models.appointments.Appointment;
import com.eikal.service.appointments.AppointmentService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author David Kinyanjui
 */

@RestController
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @PostMapping("appointment/add")
    public ResponseEntity<?> addAppointment(@RequestBody Appointment appointment){
        Appointment addedAppointment = appointmentService.addAppointment(appointment);
        return addedAppointment != null ?
                ResponseEntity.status(201).body(addedAppointment) :
                ResponseEntity.status(400).body(new GlobalError((short) 400,"Appointment was not added"));
    }

    @PutMapping("appointment/update")
    public ResponseEntity<?> updateAppointment(@RequestBody Appointment appointment,@RequestParam Long id) {
        Appointment updatedAppointment = appointmentService.updateAppointment(appointment,id);
        return updatedAppointment != null ?
                ResponseEntity.status(201).body(updatedAppointment) :
                ResponseEntity.status(400).body(new GlobalError((short) 400,"Appointment was not updated"));
    }

    @GetMapping("appointment/all")
    public ResponseEntity<?> findAllAppointments(@RequestParam int page,@RequestParam int size){
        Page<Appointment> appointmentPage = appointmentService.findAllAppointments(page,size);
        return ResponseEntity.status(200).body(appointmentPage);
    }

    @GetMapping("appointment/{id}")
    public ResponseEntity<?> findAppointmentById(@PathVariable Long id) {
        Appointment appointment = appointmentService.findAppointmentById(id);
        return appointment != null ?
                ResponseEntity.status(200).body(appointment) :
                ResponseEntity.status(404).body(new GlobalError((short) 404,"Appointment not found"));
    }

    @GetMapping("appointment/createdEmail")
    public ResponseEntity<?> findByCreatedByEmail(@RequestParam String email) {
        List<Appointment> appointments = appointmentService.findByCreatedByEmail(email);
        return !appointments.isEmpty() ?
                ResponseEntity.status(200).body(appointments) :
                ResponseEntity.status(404).body(new GlobalError((short) 404,"Appointment not found"));
    }

    @GetMapping("appointment/modifiedEmail")
    public ResponseEntity<?> findByModifiedByEmail(@RequestParam String email) {
        List<Appointment> appointments = appointmentService.findByModifiedByEmail(email);
        return appointments != null ?
                ResponseEntity.status(200).body(appointments) :
                ResponseEntity.status(404).body(new GlobalError((short) 404,"Appointment not found"));
    }

    @GetMapping("appointment/createdId")
    public ResponseEntity<?> findByCreatedById(@RequestParam Long id,@RequestParam int page,@RequestParam int size) {
        Page<Appointment> appointmentPage = appointmentService.findByCreatedById(id,page,size);
        return ResponseEntity.status(200).body(appointmentPage);
    }

    @GetMapping("appointment/modifiedId")
    public ResponseEntity<?> findByModifiedById(@RequestParam Long id,@RequestParam int page,@RequestParam int size) {
        Page<Appointment> appointmentPage = appointmentService.findByModifiedById(id,page,size);
        return ResponseEntity.status(200).body(appointmentPage);
    }

    @GetMapping("appointment/createdUsername")
    public ResponseEntity<?> findByCreatedByUsername(@RequestParam String username,@RequestParam int page,@RequestParam int size) {
        Page<Appointment> appointmentPage = appointmentService.findByCreatedByUsername(username,page,size);
        return ResponseEntity.status(200).body(appointmentPage);
    }

    @GetMapping("appointment/modifiedUsername")
    public ResponseEntity<?> findByModifiedUsername(@RequestParam String username,@RequestParam int page,@RequestParam int size) {
        Page<Appointment> appointmentPage = appointmentService.findByModifiedByUsername(username,page,size);
        return ResponseEntity.status(200).body(appointmentPage);
    }

    @GetMapping("appointment/duration")
    public ResponseEntity<?> findByDuration(@RequestParam int duration,@RequestParam int page,@RequestParam int size) {
        Page<Appointment> appointmentPage = appointmentService.findByDuration(duration,page,size);
        return ResponseEntity.status(200).body(appointmentPage);
    }

    @GetMapping("appointment/status")
    public ResponseEntity<?> findByStatus(@RequestParam String status,@RequestParam int page,@RequestParam int size) {
        Page<Appointment> appointmentPage = appointmentService.findByStatus(status,page,size);
        return ResponseEntity.status(200).body(appointmentPage);
    }

    @GetMapping("appointment/type")
    public ResponseEntity<?> findByType(@RequestParam String type,@RequestParam int page,@RequestParam int size) {
        Page<Appointment> appointmentPage = appointmentService.findByType(type,page,size);
        return ResponseEntity.status(200).body(appointmentPage);
    }

    @GetMapping("appointment/patientNationalId")
    public ResponseEntity<?> findByPatientNationalId(@RequestParam Long nationalId) {
        List<Appointment> appointments = appointmentService.findByPatientNationalId(nationalId);
        return !appointments.isEmpty() ?
                ResponseEntity.status(200).body(appointments) :
                ResponseEntity.status(404).body(new GlobalError((short) 404, "Appointment not found"));
    }

    @GetMapping("appointment/patientId")
    public ResponseEntity<?> findByPatientId(@RequestParam Long id) {
        List<Appointment> appointments = appointmentService.findByPatientId(id);
        return !appointments.isEmpty() ?
                ResponseEntity.status(200).body(appointments) :
                ResponseEntity.status(404).body(new GlobalError((short) 404,"Appointment not found"));
    }

    @GetMapping("appointment/medicalPractitionerId")
    public ResponseEntity<?> findByMedicalPractitionerId(@RequestParam Long id,@RequestParam int page,@RequestParam int size) {
        Page<Appointment> appointmentPage = appointmentService.findByMedicalPractitionerId(id,page,size);
        return ResponseEntity.status(200).body(appointmentPage);
    }

    @GetMapping("appointment/medicalPractitionerTitle")
    public ResponseEntity<?> findByMedicalPractitionerTitle(@RequestParam String title,@RequestParam int page,@RequestParam int size){
        Page<Appointment> appointmentPage = appointmentService.findByMedicalPractitionerTitle(title,page,size);
        return ResponseEntity.status(200).body(appointmentPage);
    }

    @GetMapping("appointment/departmentName")
    public ResponseEntity<?> findByDepartmentName(@RequestParam String name,@RequestParam int page,@RequestParam int size) {
        Page<Appointment> appointmentPage = appointmentService.findByDepartmentName(name,page,size);
        return ResponseEntity.status(200).body(appointmentPage);
    }

    @GetMapping("appointment/departmentId")
    public ResponseEntity<?> findByDepartment(@RequestParam Long id,@RequestParam int page,@RequestParam int size) {
        Page<Appointment> appointmentPage = appointmentService.findByDepartmentId(id,page,size);
        return ResponseEntity.status(200).body(appointmentPage);
    }
}
