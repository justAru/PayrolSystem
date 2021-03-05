package com.iitu.pairoll;

import com.iitu.pairoll.config.SpringConfig;
import com.iitu.pairoll.controller.EmployeeController;
import com.iitu.pairoll.model.Employee;
import com.iitu.pairoll.repository.EmployeeRepository;
import com.iitu.pairoll.service.EmployeeService;
import com.iitu.pairoll.service.impl.EmployeeSalaryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);


        EmployeeSalaryService service = context.getBean(EmployeeSalaryService.class);

        Employee employee = new Employee();
        employee.setName("Aruzhan");
        employee.setSalary(200000);
//        employee.getEmployeeType();


        while (true) {

            System.out.println("\nWelcome!\n");

            System.out.println("<------------------------------->");
            System.out.println("<          1.Add User           >");
            System.out.println("<          2.Salary update      >");
            System.out.println("<          3.All employees      >");
            System.out.println("<          0.Exit               >");
            System.out.println("<------------------------------->");

            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    service.create(employee);
                    break;
                case 2:
//                    atm.topUp();
                    break;
                case 3:
//                    atm.withdraw();
                    break;
                case 0:
                    System.exit(200);
                default:
                    System.out.println("Try Again!");
            }
        }

    }
    }
