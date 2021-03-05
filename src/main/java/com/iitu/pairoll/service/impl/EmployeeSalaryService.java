package com.iitu.pairoll.service.impl;

import com.iitu.pairoll.model.Employee;
import com.iitu.pairoll.model.EmployeeType;
import com.iitu.pairoll.repository.EmployeeRepository;
import com.iitu.pairoll.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

@Service
public class EmployeeSalaryService implements EmployeeService {
    Scanner scanner = new Scanner(System.in);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void create(Employee employee) throws SQLException {
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter salary: ");
        Integer salary = scanner.nextInt();

        System.out.println("Choose User Type: ");
        System.out.println("1." + EmployeeType.SALARIED);
        System.out.println("2." + EmployeeType.HOURLY);
        System.out.println("3." + EmployeeType.COMMISION);
        System.out.println("4." + EmployeeType.SALARIED_COMMISION);
        System.out.print("Choice : ");
        int choice = scanner.nextInt();

        EmployeeType type;

        switch (choice){
            case 1:
                type = EmployeeType.SALARIED;
                break;
            case 2:
                type = EmployeeType.HOURLY;
                break;
            case 3:
                type = EmployeeType.COMMISION;
                break;
            case 4:
                type = EmployeeType.SALARIED_COMMISION;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }

        Employee employee1 = new Employee();
        employee1.setEmployeeType(type);
        employee1.setSalary(salary);
        employee1.setName(name);
        employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> getAll() {
        Pageable pageable = PageRequest.of(0, 6, Sort.by(Sort.Direction.DESC,"name"));
        return employeeRepository.findAll(pageable);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public void updateSalary(Long id, Employee employee) {
        System.out.print("Enter employee's ID: ");
        int cardNumber = scanner.nextInt();
        Employee employee2 = employeeRepository.getById(id);
        int salary = employee2.getSalary();

        System.out.println("1. Increase");
        System.out.println("2. Decrease");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter percentage of increase: ");
            int per = scanner.nextInt();
            employee2.setSalary(salary + salary * per / 100);
            employeeRepository.save(employee2);
        } else {
            System.out.print("Enter percentage of decrease: ");
            int per = scanner.nextInt();
            employee2.setSalary(salary + salary * per / 100);
            employeeRepository.save(employee2);
        }
    }

    @Override
    public List<Employee> listOfAllEmployees(Employee employee) {
        return employeeRepository.findAll();
    }
}
