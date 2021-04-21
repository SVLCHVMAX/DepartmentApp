package ru.savelchev.service;

import ru.savelchev.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getStaff(int departmentId);
}
