package com.example.demo.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Data
@Component
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "fixed_salary")
    private Double fixedSalary;

    @Column(name = "hour_rate")
    private Double hourRate;

    @Column(name = "hours_worked")
    private Integer hoursWorked;

    @Column(name = "comm_rate")
    private Double commRate;

    @Column(name = "employee_type")
    private EmployeeType employeeType;


}
