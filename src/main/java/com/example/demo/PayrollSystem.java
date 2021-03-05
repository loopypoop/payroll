package com.example.demo;

import com.example.demo.config.SpringConfig;
import com.example.demo.controller.EmployeeController;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeType;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class PayrollSystem {

    public void menu() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Scanner in = new Scanner(System.in);
        EmployeeController employeeController = context.getBean(EmployeeController.class);
        int choice = -1;

        while (choice != 0) {
            System.out.println("1. Create Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Update Salary of employee");
            System.out.println("4. Show list of employees");
            System.out.println("0. Exit");

            choice = in.nextInt();

            switch (choice) {
                case 1:
                    Employee employee = new Employee();
                    System.out.print("Enter name:");
                    String name = in.next();
                    employee.setName(name);
                    System.out.println(name);
                    System.out.println("0 --> SALARIED");
                    System.out.println("1 --> HOURLY");
                    System.out.println("2 --> COMMISSION");
                    System.out.println("3 --> SALARIED_COMMISSION");
                    System.out.print("Enter type of employee from above:");
                    int choiceType = in.nextInt();
                    EmployeeType employeeType = EmployeeType.SALARIED;
                    switch (choiceType) {
                        case 0:
                            employeeType = EmployeeType.SALARIED;
                            break;
                        case 1:
                            employeeType = EmployeeType.HOURLY;
                            break;
                        case 2:
                            employeeType = EmployeeType.COMMISSION;
                            break;
                        case 3:
                            employeeType = EmployeeType.SALARIED_COMMISSION;
                            break;
                    }
                    employee.setEmployeeType(employeeType);
                    System.out.print("Enter salary: ");
                    Double salary = in.nextDouble();
                    employee.setFixedSalary(salary);
                    System.out.println(salary);
                    System.out.print("Enter commission rate:");
                    Double commRate = in.nextDouble();
                    employee.setCommRate(commRate);
                    System.out.println(commRate);
                    System.out.print("Enter hour rate:");
                    Double hourRate = in.nextDouble();
                    employee.setHourRate(hourRate);
                    System.out.println(hourRate);
                    System.out.print("Enter hour worked:");
                    Integer hours = in.nextInt();
                    employee.setHoursWorked(hours);
                    System.out.println(hours);
                    employeeController.createEmployee(employee);
                    break;
                case 2:
                    System.out.print("Enter id of the employee: ");
                    Integer deleteId = in.nextInt();
                    employeeController.deleteEmployee(deleteId);
                    break;
                case 3:
                    System.out.print("Enter id of the employee: ");
                    Integer updateId = in.nextInt();
                    employeeController.updateSalary(updateId);
                    break;
                case 4:
                    employeeController.getEmployees();
                    break;

            }
        }
    }
}
