package ru.savelchev.dao;


import ru.savelchev.model.Department;

import java.util.List;

public interface DepartmentDAO {

    List<Department> getDepartments();
    void save(Department department);
}
