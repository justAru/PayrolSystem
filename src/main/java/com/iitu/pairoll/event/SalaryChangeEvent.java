package com.iitu.pairoll.event;

import com.iitu.pairoll.model.Employee;
import org.springframework.context.ApplicationEvent;

public class SalaryChangeEvent extends ApplicationEvent {
    private final Employee employee;

    public SalaryChangeEvent(Object source, Employee employee) {
        super(source);
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
