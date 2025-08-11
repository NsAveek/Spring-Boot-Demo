package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepo employeeRepo;
    @Override
    public Employee add(Employee employee) {
        // Implementation for adding an employee
        // This method will interact with the EmployeeRepo to perform the save operation.
        // For example:
         return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> retrieveAllEmployees() {
        // Implementation for retrieving all employees
        // This method will interact with the EmployeeRepo to fetch all employee records.
        // For example:
         return employeeRepo.findAll();
    }

    @Override
    public Employee update(Employee employee) {
        // Implementation for updating an employee
        // This method will interact with the EmployeeRepo to perform the update operation.
        // For example:
         return employeeRepo.save(employee);
    }

    @Override
    public void delete(Long id) {
        // Implementation for deleting an employee by id
        // This method will interact with the EmployeeRepo to perform the delete operation.
        // For example:
         employeeRepo.deleteById(id);
    }

    @Override
    public Optional<Employee> findById(Long id) throws Exception {
        return Optional.ofNullable(employeeRepo.findById(id).orElseThrow(() -> new Exception("Employee not found")));
    }
}
