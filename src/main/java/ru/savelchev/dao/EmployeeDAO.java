package ru.savelchev.dao;

import ru.savelchev.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getStaff(int departmentId);
}
