package com.eikal.controller.facility;

import com.eikal.models.facility.Department;
import com.eikal.models.facility.EmployeeDepartment;
import com.eikal.service.facility.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("department/save")
    public ResponseEntity<?> saveDepartment(@RequestBody Map<String, Object> departmentMap) {
        Department savedDepartment = departmentService.saveDepartment(departmentMap);
        return savedDepartment != null ?
                ResponseEntity.status(201).body(savedDepartment) :
                ResponseEntity.status(415).build();
    }

    @GetMapping("department/{id}")
    public ResponseEntity<?> findDepartment(@PathVariable Long id) {
        Department department = departmentService.findDepartmentById(id);
        return department == null ?
                ResponseEntity.status(404).body("Department not found") :
                ResponseEntity.status(200).body(department);
    }

    @GetMapping(value = {"departments/search", "departments"})
    public ResponseEntity<?> findDepartmentInFacility(@RequestParam("facilityId") Long id) {
        List<Department> departments = departmentService.findAllDepartmentsInFacility(id);
        return departments.isEmpty() ?
                ResponseEntity.status(404).body("No department found") :
                ResponseEntity.status(200).body(departments);
    }

    @PostMapping("employee/addDepartment")
    public ResponseEntity<?> saveEmpDep(@RequestBody Map<String, Object> map) {
        EmployeeDepartment employeeDepartment = departmentService.saveEmpDep(map);
        return employeeDepartment  != null ?
                ResponseEntity.status(201).body(employeeDepartment) :
                ResponseEntity.status(415).build();
    }

    @GetMapping("department/members")
    public ResponseEntity<?> findAllEmpInDep(@RequestParam("depId") Long depId) {
        List<EmployeeDepartment> departments = departmentService.findAllEmployeesInDepartment(depId);
        return departments.isEmpty() ?
                ResponseEntity.status(404).body("No Employee was found in this department") :
                ResponseEntity.status(200).body(departments);    }

    @GetMapping("employee/departments")
    public ResponseEntity<?> findAllEmpDeps(@RequestParam("empId") Long empId) {
        List<EmployeeDepartment> departments = departmentService.findAllEmployeeDepartments(empId);
        return departments.isEmpty() ?
                ResponseEntity.status(404).body("This employee is not found in any department") :
                ResponseEntity.status(200).body(departments);
    }

}
