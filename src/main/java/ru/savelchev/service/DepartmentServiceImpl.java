package ru.savelchev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.savelchev.dao.DepartmentDAO;
import ru.savelchev.model.Department;
import ru.savelchev.model.Employee;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentDAO departmentDAO;

    @Autowired
    public DepartmentServiceImpl(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    @Override
    @Transactional
    public List<Department> getDepartments() {
        return departmentDAO.getDepartments();
    }

    @Transactional
    public void save(Department department) {
        departmentDAO.save(department);
    }

    @Override
    @Transactional
    public void deleteDepartment(int id) {
        departmentDAO.deleteDepartment(id);
    }

    @Override
    @Transactional
    public List<Employee> getEmployees(int id) {
        return departmentDAO.getEmployees(id);
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        departmentDAO.addEmployee(employee);
    }

    @Override
    @Transactional
    public Department findById(int id) {
        return departmentDAO.findById(id);
    }


}
