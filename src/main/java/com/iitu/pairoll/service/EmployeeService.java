package com.iitu.pairoll.service;

import com.iitu.pairoll.model.Employee;
import org.springframework.data.domain.Page;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {
public void create(Employee employee) throws SQLException;
Page<Employee> getAll();
List<Employee> getEmployeesByName(String name);
public void updateSalary(Long id, Employee employee);
public List<Employee> listOfAllEmployees(Employee employee);
}
