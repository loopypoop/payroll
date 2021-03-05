package com.example.demo;

import com.example.demo.config.SpringConfig;
import com.example.demo.controller.EmployeeController;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeType;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PayrollSystem payroll = new PayrollSystem();
        payroll.menu();
    }
}
