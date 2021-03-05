package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee increaseSalary(Integer id) {
        Scanner in = new Scanner(System.in);
        Employee employee = employeeRepository.getById(id);
        System.out.print("Increase salary to (%): ");
        Double increase = in.nextDouble();

        switch (employee.getEmployeeType()) {
            case HOURLY:
                if (employee.getHourRate() <= 40) {
                    employee.setFixedSalary(employee.getFixedSalary() + employee.getFixedSalary() * (increase / 100));
                } else {
                    employee.setFixedSalary((employee.getFixedSalary() + employee.getFixedSalary() * (increase / 100)) * 1.5);
                }

                break;
            case SALARIED:
                employee.setFixedSalary(employee.getFixedSalary() + employee.getFixedSalary() * (increase / 100));
                break;
            case COMMISSION:
                employee.setFixedSalary(employee.getFixedSalary() +
                        employee.getFixedSalary() * ((increase / 100) + employee.getCommRate()));
                break;
            case SALARIED_COMMISSION:
                employee.setFixedSalary(employee.getFixedSalary() +
                        employee.getFixedSalary() * (increase / 100) + employee.getFixedSalary() *  employee.getCommRate());
                break;
        }


        return employeeRepository.save(employee);
    }

    @Override
    public Employee decreaseSalary(Integer id) {
        Scanner in = new Scanner(System.in);
        Employee employee = employeeRepository.getById(id);
        System.out.print("Increase salary to (%): ");
        Double decrease = in.nextDouble();

        switch (employee.getEmployeeType()) {
            case HOURLY:
                if (employee.getHourRate() <= 40) {
                    employee.setFixedSalary(employee.getFixedSalary() - employee.getFixedSalary() * (decrease / 100));
                } else {
                    employee.setFixedSalary((employee.getFixedSalary() - employee.getFixedSalary() * (decrease / 100)) * 1.5);
                }

                break;
            case SALARIED:
                employee.setFixedSalary(employee.getFixedSalary() + employee.getFixedSalary() * (decrease / 100));
                break;
            case COMMISSION:
                employee.setFixedSalary(employee.getFixedSalary() -
                        employee.getFixedSalary() * ((decrease / 100) + employee.getCommRate()));
                break;
            case SALARIED_COMMISSION:
                employee.setFixedSalary(employee.getFixedSalary() -
                        employee.getFixedSalary() * (decrease / 100) + employee.getFixedSalary() *  employee.getCommRate());
                break;
        }

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
}
