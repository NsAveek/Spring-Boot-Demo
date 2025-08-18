package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepo employeeRepo;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Override

    public Employee add(Employee employee) {
         return employeeRepo.save(employee);
    }

    @Override
    @Cacheable(value = "employeeCache")
    public List<Employee> retrieveAllEmployees() {
         List<Employee> allEmployees = employeeRepo.findAll();
        logger.info("Caching {} users", allEmployees.size());
        allEmployees.forEach(user -> logger.info("User: id={}, name={}, email={}",
                user.getId(), user.getName(), user.getEmail()));
         return  allEmployees;
    }

    @Override
    @CacheEvict(value = "employeeCache", key = "#employee.id")
    public Employee update(Employee employee) {
         return employeeRepo.save(employee);
    }

    @Override

    public void delete(Long id) {
         employeeRepo.deleteById(id);
    }

    @Override
    @Cacheable(value = "employeeCache", key = "#employeeId")
    public Optional<Employee> findById(Long id) throws Exception {
        return  employeeRepo.findById(id);
    }

    @CacheEvict(value = "employeeCache", allEntries = true)
    public void clearUserCache() {
        // Clears all user cache entries
    }
}
