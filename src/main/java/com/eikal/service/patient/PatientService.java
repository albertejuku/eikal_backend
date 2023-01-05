package com.eikal.service.patient;

import com.eikal.models.facility.Employee;
import com.eikal.models.facility.Facility;
import com.eikal.models.patient.Patient;
import com.eikal.models.people.User;
import com.eikal.repository.patient.PatientRepository;
import com.eikal.service.facility.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Service
public class PatientService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final PatientRepository patientRepository;
    private final EmployeeService employeeService;

    @Autowired
    public PatientService(PatientRepository patientRepository, EmployeeService employeeService) {
        this.patientRepository = patientRepository;
        this.employeeService = employeeService;
    }

    public Patient saveWithExistingUser(Map<? extends String, Object> map) {
        Employee employee = employeeService.findById(Long.parseLong((String) map.get("createdBy")));

        Patient patient = new Patient();
        patient.setUser(new User(Long.parseLong(String.valueOf(map.get("user")))));
        patient.setFacility(new Facility(Long.parseLong((String) map.get("facility"))));
        patient.setCreatedBy(employee);
        patient.setModifiedBy(employee);
        patient.setNationalId(Long.valueOf((String) map.get("nationalId")));
        patient.setPersonalId(Boolean.parseBoolean(String.valueOf(map.get("isPersonalId"))));
        patient.setRelationship((String) map.get("relationship"));
        patient.setDateCreated(LocalDateTime.now());
        patient.setDateModified(LocalDateTime.now());
        return patientRepository.save(patient);
    }

    public Patient savePatient(Map<String, Object> map) {
        Employee employee = employeeService.findById(Long.parseLong((String) map.get("createdBy")));

        User user = objectMapper.convertValue(map.get("user"), User.class);
        user.setDateCreated(LocalDateTime.now());
        user.setDateModified(LocalDateTime.now());
        user.setBirthDate(LocalDate.parse((String) map.get("DOB"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        Patient patient = new Patient();
        patient.setUser(user);
        patient.setFacility(new Facility(Long.parseLong((String) map.get("facility"))));
        patient.setCreatedBy(employee);
        patient.setModifiedBy(employee);
        patient.setNationalId(Long.valueOf((String) map.get("nationalId")));
        patient.setPersonalId(Boolean.parseBoolean(String.valueOf(map.get("isPersonalId"))));
        patient.setRelationship((String) map.get("relationship"));
        patient.setDateCreated(LocalDateTime.now());
        patient.setDateModified(LocalDateTime.now());

        return patientRepository.save(patient);
    }

    public Patient findPatient(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public Page<Patient> findPatientsInFacility(Long facilityId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return patientRepository.findAllByFacility_Id(facilityId, pageable);
    }

    public List<Patient> findPatientByNationalID(long nationalId) {
        return patientRepository.findAllByUser_NationalId(nationalId);
    }

    public List<Patient> findPatientByBirthCert(long birthCert) {
        return patientRepository.findAllByUser_BirthCertNoContaining(birthCert);
    }

    public List<Patient> findPatientByPhone(String phone) {
        return patientRepository.findAllByUser_PhoneContaining(phone);
    }

    public List<Patient> findPatientByEmail(String email) {
        return patientRepository.findAllByUser_EmailContaining(email);
    }

    public List<Patient> findPatientByUsername(String username) {
        return patientRepository.findAllByUser_UsernameContaining(username);
    }

}
