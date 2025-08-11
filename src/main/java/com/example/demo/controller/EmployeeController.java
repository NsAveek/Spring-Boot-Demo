package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    // Define endpoints for employee operations here
    // For example:
     @PostMapping("/add")
     public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
         return ResponseEntity.ok(employeeService.add(employee));
     }
     @GetMapping("/all")
     public ResponseEntity<List<Employee>> getAllEmployees() {
         return ResponseEntity.ok(employeeService.retrieveAllEmployees());
     }
     @PutMapping("/{id}")
     public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
         employee.setId(id);
         return ResponseEntity.ok(employeeService.update(employee));
     }
     @DeleteMapping("/{id}")
     public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
         employeeService.delete(id);
         return ResponseEntity.noContent().build();
     }

}
