package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        System.out.println("User created!");
        return employeeService.create(employee);
    }

    public void updateSalary (Integer id) {
        Employee employee = employeeRepository.getById(id);
        Double oldSalary = employee.getFixedSalary();
        Scanner in = new Scanner(System.in);
        System.out.println("1. Increase");
        System.out.println("2. Decrease");
        Integer choice = in.nextInt();
        if (choice == 1)
            employeeService.increaseSalary(id);
        else if (choice == 2)
            employeeService.decreaseSalary(id);

        employee = employeeRepository.getById(id);

        System.out.println("Updated " + employee.getName() + "'s salary from " +
                oldSalary + " to " + employee.getFixedSalary());
    }

    public void getEmployees() {
        List<Employee> employees = employeeService.getEmployees();
        for (Employee employee: employees) {
            System.out.println(employee.toString());
        }
    }

    public void deleteEmployee(Integer id) {
        employeeService.delete(id);
        System.out.println("Deleted!");
    }
}
