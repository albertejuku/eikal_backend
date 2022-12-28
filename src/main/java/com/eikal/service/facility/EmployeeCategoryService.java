package com.eikal.service.facility;

import com.eikal.models.facility.EmployeeCategory;
import com.eikal.models.facility.EmployeeGroup;
import com.eikal.models.facility.Facility;
import com.eikal.repository.facility.EmployeeCategoryRepository;
import com.eikal.repository.facility.EmployeeGroupRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Service
public class EmployeeCategoryService {

    private final EmployeeCategoryRepository employeeCategoryRepository;
    private final EmployeeGroupRepository employeeGroupRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public EmployeeCategoryService(EmployeeCategoryRepository employeeCategoryRepository, EmployeeGroupRepository employeeGroupRepository) {
        this.employeeCategoryRepository = employeeCategoryRepository;
        this.employeeGroupRepository = employeeGroupRepository;
    }

    public EmployeeCategory saveCategory(Map<String, Object> groupMap) {
        EmployeeCategory employeeCategory = objectMapper.convertValue(groupMap.get("category"), EmployeeCategory.class);
        employeeCategory.setGroup(new EmployeeGroup(Long.valueOf((Integer) groupMap.get("group"))));
        employeeCategory.setDateCreated(LocalDateTime.now());
        employeeCategory.setDateModified(LocalDateTime.now());
        return employeeCategoryRepository.save(employeeCategory);
    }

    public EmployeeCategory updateCategory(EmployeeCategory category) {
        return employeeCategoryRepository.save(category);
    }

    public EmployeeCategory findCategoryById(Long id) {
        return employeeCategoryRepository.findById(id).orElse(null);
    }

    public List<EmployeeCategory> findCategoriesInGroup(Long groupId) {
        return employeeCategoryRepository.findAllByGroup_Id(groupId);
    }

    public List<EmployeeCategory> findCategoriesInFacility(Long facilityId) {
        return employeeCategoryRepository.findAllByGroup_Facility_Id(facilityId);
    }

    public EmployeeGroup saveGroup(Map<String, Object> groupMap) {
        EmployeeGroup employeeGroup = objectMapper.convertValue(groupMap.get("group"), EmployeeGroup.class);
        employeeGroup.setFacility(new Facility(Long.valueOf(String.valueOf(groupMap.get("facility")))));
        employeeGroup.setDateCreated(LocalDateTime.now());
        employeeGroup.setDateModified(LocalDateTime.now());
        return employeeGroupRepository.save(employeeGroup);
    }

    public EmployeeGroup updateGroup(EmployeeGroup employeeGroup) {
        return employeeGroupRepository.save(employeeGroup);
    }

    public EmployeeGroup findGroupById(Long groupId) {
        return employeeGroupRepository.findById(groupId).orElse(null);
    }

    public List<EmployeeGroup> findGroupsInFacility(Long facilityId) {
        return employeeGroupRepository.findAllByFacility_Id(facilityId);
    }

}
