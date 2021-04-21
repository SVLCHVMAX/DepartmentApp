package ru.savelchev.dao;


import ru.savelchev.model.Department;
import ru.savelchev.model.Employee;

import java.util.List;

public interface DepartmentDAO {

    List<Department> getDepartments();
    void save(Department department);
    void deleteDepartment(int id);
    List<Employee>  getEmployees(int id);
    void addEmployee(Employee employee);
}
