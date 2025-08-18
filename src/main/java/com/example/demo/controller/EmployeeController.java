package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    private RedisTemplate<String, String> template;

    private static final String STRING_KEY_PREFIX = "redi2read:strings:";



    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
     @PostMapping("/add")
     public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
//         template.opsForValue().set(STRING_KEY_PREFIX + "all", Objects.requireNonNull(template.opsForValue().get("all")));
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
     @GetMapping("/{id}")
     public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(employeeService.findById(id).orElseThrow(() -> new Exception("Employee not found")));
     }
}
