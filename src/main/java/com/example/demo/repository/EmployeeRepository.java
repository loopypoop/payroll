package com.example.demo.repository;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee getById(Integer id);
    List<Employee> getEmployeeByEmployeeType(EmployeeType employeeType);
}
