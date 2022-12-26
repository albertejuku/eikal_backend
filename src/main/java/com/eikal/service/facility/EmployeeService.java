package com.eikal.service.facility;

import com.eikal.models.facility.Employee;
import com.eikal.models.facility.EmployeeCategory;
import com.eikal.models.facility.Facility;
import com.eikal.models.people.AppUser;
import com.eikal.repository.facility.EmployeeRepository;
import com.eikal.service.people.AppUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Service
public class EmployeeService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private final EmployeeRepository employeeRepository;
    private final AppUserService appUserService;
    private final EmployeeCategoryService categoryService;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, AppUserService appUserService, EmployeeCategoryService employeeCategoryService) {
        this.employeeRepository = employeeRepository;
        this.appUserService = appUserService;
        this.categoryService = employeeCategoryService;
    }

    public Employee saveEmployee(Map<String, Object> employeeMap) {
        Employee employee = objectMapper.convertValue(employeeMap.get("employee"), Employee.class);
        AppUser createdBy = appUserService.getUserById(Long.valueOf((Integer) employeeMap.get("createdBy")));

        AppUser appUser = objectMapper.convertValue(employeeMap.get("appUser"), AppUser.class);
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUser.setDateCreated(LocalDateTime.now());
        employee.setCreatedBy(createdBy);
        employee.setModifiedBy(createdBy);

        employee.setAppUser(appUser);
        employee.setFacility(new Facility(Long.valueOf((Integer) employeeMap.get("facility"))));

        EmployeeCategory category = categoryService.findCategoryById(Long.valueOf((Integer) employeeMap.get("category")));
        employee.setCategory(category);
        return employeeRepository.save(employee);
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> findAllEmployeesInFacility(Long facilityId) {
        return employeeRepository.findAllByFacility_Id(facilityId);
    }
}
