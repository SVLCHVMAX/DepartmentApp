package ru.savelchev.service;

import ru.savelchev.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getDepartments();
   void save(Department department);
}
