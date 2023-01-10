package com.eikal.service.facility;

import com.eikal.models.facility.*;
import com.eikal.models.people.AppUser;
import com.eikal.repository.facility.DepartmentRepository;
import com.eikal.repository.facility.EmployeeDepartmentRepository;
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
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeDepartmentRepository employeeDepartmentRepository;
    private final EmployeeService employeeService;

    @Autowired
    public DepartmentService(EmployeeService employeeService, DepartmentRepository departmentRepository, EmployeeDepartmentRepository employeeDepartmentRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeDepartmentRepository = employeeDepartmentRepository;
        this.employeeService = employeeService;
    }

    public Department saveDepartment(Map<String, Object> departmentMap) {
        Department department = new Department();
        department.setName((String) departmentMap.get("name"));
        department.setDetails((String) departmentMap.get("details"));
        Employee employee = employeeService.findById(Long.valueOf((Integer) departmentMap.get("createdBy")));
        department.setCreatedBy(employee);
        department.setModifiedBy(employee);
        department.setDateCreated(LocalDateTime.now());
        department.setDateModified(LocalDateTime.now());
        department.setFacility(new Facility(Long.valueOf(String.valueOf(departmentMap.get("facility")))));
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public List<Department> findAllDepartmentsInFacility(Long facilityId) {
        return departmentRepository.findAllByFacility_Id(facilityId);
    }

    public EmployeeDepartment saveEmpDep(Map<String, Object> map) {
        EmployeeDepartment employeeDepartment = new EmployeeDepartment();
        employeeDepartment.setTitle(DepartmentTitle.valueOf((String) map.get("title")));
        employeeDepartment.setEmployee(employeeService.findById(Long.valueOf(String.valueOf(map.get("employee")))));
        employeeDepartment.setDepartment(this.findDepartmentById(Long.valueOf(String.valueOf(map.get("department")))));
        employeeDepartment.setDateModified(LocalDateTime.now());
        employeeDepartment.setDateCreated(LocalDateTime.now());
        return employeeDepartmentRepository.save(employeeDepartment);
    }

    public List<EmployeeDepartment> findAllEmployeesInDepartment(Long depId) {
        return employeeDepartmentRepository.findAllByDepartment_Id(depId);
    }

    public List<EmployeeDepartment> findAllEmployeeDepartments(Long empId) {
        return employeeDepartmentRepository.findAllByEmployee_Id(empId);
    }
}
