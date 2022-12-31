package com.eikal.controller.patient;

import com.eikal.models.patient.Patient;
import com.eikal.service.patient.PatientService;
import com.eikal.error.GlobalError;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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
                ResponseEntity.status(400).body(new GlobalError((short) 400, "Could not create patient"));
    }

    @GetMapping("patient/{id}")
    public ResponseEntity<?> findPatient(@PathVariable Long id) {
        Patient patient = patientService.findPatient(id);
        return patient != null ?
                ResponseEntity.status(200).body(patient) :
                ResponseEntity.status(404).body(new GlobalError((short) 404, "patient not found"));
    }

    @GetMapping("patients/facility")
    public ResponseEntity<?> findPatientsInFacility(@RequestParam("id") Long facilityId, @RequestParam int page, @RequestParam int size) {
        Page<Patient> patientPage = patientService.findPatientsInFacility(facilityId, page, size);
        return ResponseEntity.status(200).body(patientPage);
    }

    @GetMapping("patients/search")
    public ResponseEntity<?> findPatientByParameters(
            @RequestParam(required=false) Long nationalID,
            @RequestParam(required=false) Long birthCert,
            @RequestParam(required=false) String phone,
            @RequestParam(required=false) String email,
            @RequestParam(required=false) String username
    ) {
        List<Patient> patients = new ArrayList<>();

        if(nationalID != null) {
            patients = patientService.findPatientByNationalID(nationalID);
        } else if (birthCert != null) {
            patients = patientService.findPatientByBirthCert(birthCert);
        } else if (phone != null) {
            patients = patientService.findPatientByPhone(phone);
        } else if(email != null) {
            patients = patientService.findPatientByEmail(email);
        } else if(username != null) {
            patients = patientService.findPatientByUsername(username);
        }

        return !patients.isEmpty() ?
                ResponseEntity.ok().body(patients) :
                ResponseEntity.status(404).body(new GlobalError((short) 404, "No patient found"));
    }

}