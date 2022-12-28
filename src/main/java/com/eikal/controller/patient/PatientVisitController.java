package com.eikal.controller.patient;

import com.eikal.models.patient.PatientVisit;
import com.eikal.service.patient.PatientVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PatientVisitController {

    private final PatientVisitService visitService;

    @Autowired
    public PatientVisitController(PatientVisitService visitService) {
        this.visitService = visitService;
    }

    @PostMapping("visit/save")
    public ResponseEntity<?> saveVisit(@RequestBody Map<String, Object> map) {
        PatientVisit patientVisit = visitService.saveVisit(map);
        return patientVisit != null ?
                ResponseEntity.status(201).body(patientVisit) :
                ResponseEntity.status(415).build();
    }

    @GetMapping("visit/{id}")
    public ResponseEntity<?> findVisit(@PathVariable Long id) {
        PatientVisit patientVisit = visitService.findVisit(id);
        return patientVisit != null ?
                ResponseEntity.status(200).body(patientVisit) :
                ResponseEntity.notFound().build();
    }

    @GetMapping("visit/patient")
    public ResponseEntity<?> findVisitsByPatient(@RequestParam Long id) {
        List<PatientVisit> visits = visitService.findVisitsByPatient(id);
        return !visits.isEmpty() ?
                ResponseEntity.status(200).body(visits) :
                ResponseEntity.notFound().build();
    }

    @GetMapping("visit/facility")
    public ResponseEntity<?> findVisitsByFacility(@RequestParam Long id) {
        List<PatientVisit> visits = visitService.findVisitsByFacility(id);
        return !visits.isEmpty() ?
                ResponseEntity.status(200).body(visits) :
                ResponseEntity.notFound().build();
    }

 @GetMapping("visit/department")
    public ResponseEntity<?> findVisitsByDepartment(@RequestParam Long id, @RequestParam int page, @RequestParam int size) {
        Page<PatientVisit> visits = visitService.findAllInDepartment(id, page, size);
        return ResponseEntity.status(200).body(visits);
    }


    @GetMapping("visits")
    public ResponseEntity<?> findAllVisits(@RequestParam int page, @RequestParam int size) {
        List<PatientVisit> visits = visitService.findAllVisits(page, size);
        return !visits.isEmpty() ?
                ResponseEntity.status(200).body(visits) :
                ResponseEntity.notFound().build();
    }

}
