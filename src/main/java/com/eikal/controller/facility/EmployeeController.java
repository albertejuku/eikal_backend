package com.eikal.controller.facility;

import com.eikal.models.facility.Employee;
import com.eikal.service.facility.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("employee/save")
    public ResponseEntity<?> saveEmployee(@RequestBody Map<String, Object> employeeMap) {
        Employee savedEmployee = employeeService.saveEmployee(employeeMap);
        if(savedEmployee != null) {
            return ResponseEntity.status(201).body(savedEmployee);
        }
        return ResponseEntity.status(415).build();
    }

    @GetMapping("employee/{id}")
    public ResponseEntity<?> findEmp(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);

        return employee == null ?
                ResponseEntity.status(404).body("Employee not found") :
                ResponseEntity.status(200).body(employee);
    }

    @GetMapping("employees/facility")
    public ResponseEntity<?> findEmployeesInFacility(@RequestParam("id") Long id) {
        List<Employee> employees = employeeService.findAllEmployeesInFacility(id);
        return employees.isEmpty() ?
                ResponseEntity.status(404).body("Facility has no employees") :
                ResponseEntity.status(200).body(employees);
    }

}
