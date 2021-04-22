package ru.savelchev.dao;

import ru.savelchev.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getStaff(int departmentId);
    void save(Employee employee);
    void deleteById(int id);
    Employee findById(int id);
    List<Employee> findAll();
}
