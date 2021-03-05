package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;

public interface IEmployeeService {

    Employee create(Employee employee);
    void delete(Integer id);

    Employee increaseSalary(Integer id);

    Employee decreaseSalary(Integer id);

    List<Employee> getEmployees();
}
