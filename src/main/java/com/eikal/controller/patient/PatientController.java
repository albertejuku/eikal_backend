package com.eikal.controller.patient;

import com.eikal.models.patient.Patient;
import com.eikal.service.patient.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@RestController
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("patient/save")
    public ResponseEntity<?> savePatient(@RequestBody Map<? extends String, Object> map) {
        Patient patient = patientService.savePatient(map);
        return patient != null ?
                ResponseEntity.status(201).body(patient) :
                ResponseEntity.status(415).build();
    }

    @GetMapping("patient/{id}")
    public ResponseEntity<?> findPatient(@PathVariable Long id) {
        Patient patient = patientService.findPatient(id);
        return patient != null ?
                ResponseEntity.status(200).body(patient) :
                ResponseEntity.status(404).body("patient not found");
    }

    @GetMapping("patients/facility")
    public ResponseEntity<?> findPatientsInFacility(@RequestParam("id") Long facilityId, @RequestParam int page, @RequestParam int size) {
        Page<Patient> patientPage = patientService.findPatientsInFacility(facilityId, page, size);
        return ResponseEntity.status(200).body(patientPage);
    }

}