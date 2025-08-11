package com.example.demo.service;

import com.example.demo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {

    Employee add(Employee employee);
    List<Employee> retrieveAllEmployees();
    Employee update(Employee employee);
    void delete(Long id);
    Optional<Employee> findById(Long id) throws Exception;
//    @Autowired
//    private EmployeeRepo employeeRepo;


//    public EmployeeResponse getEmployeeById(Long id) {
//        Optional<Employee> employee = employeeRepo.findById(id);
//
//        EmployeeResponse employeeResponse = modelMap.m
//    }

}
