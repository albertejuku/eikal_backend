package com.eikal.service.patient;

import com.eikal.models.facility.Department;
import com.eikal.models.facility.Employee;
import com.eikal.models.patient.Patient;
import com.eikal.models.patient.PatientVisit;
import com.eikal.models.patient.PatientVisitType;
import com.eikal.repository.patient.PatientVisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class PatientVisitService {

    private final PatientVisitRepository visitRepository;

    @Autowired
    public PatientVisitService(PatientVisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public PatientVisit saveVisit(Map<String, Object> map) {
        PatientVisit visit = new PatientVisit();
        visit.setVisitType(PatientVisitType.valueOf((String) map.get("visitType")));
        visit.setCause((String) map.get("cause"));
        visit.setDetails((String) map.get("details"));
        visit.setStatus((String) map.get("status"));
        visit.setCreatedBy(new Employee(Long.parseLong((String) map.get("createdBy"))));
        visit.setModifiedBy(new Employee(Long.parseLong((String) map.get("createdBy"))));
        visit.setModificationReason("Initial Created");
        visit.setDepartment(new Department(Long.parseLong((String) map.get("department"))));
        visit.setPatient(new Patient(Long.parseLong((String) map.get("patient"))));
        visit.setDateVisited(LocalDateTime.now());
        visit.setDateModified(LocalDateTime.now());
        visit.setBillable(Boolean.parseBoolean((String) map.get("billable")));
        visit.setBilled(Boolean.parseBoolean((String) map.get("billed")));
        visit.setDischarged(Boolean.parseBoolean((String) map.get("discharged")));
        return visitRepository.save(visit);
    }

    public PatientVisit findVisit(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    public List<PatientVisit> findVisitsByPatient(Long id) {
        return visitRepository.findAllByPatient_Id(id);
    }

    public List<PatientVisit> findVisitsByFacility(Long id) {
        return visitRepository.findAllByDepartment_Facility_Id(id);
    }

    public List<PatientVisit> findAllVisits(int page, int size) {
        return visitRepository.findAll();
    }

    public Page<PatientVisit> findAllInDepartment(Long depId, int page, int size) {
        return visitRepository.findAllByDepartment_Id(depId, PageRequest.of(page, size));
    }

}
