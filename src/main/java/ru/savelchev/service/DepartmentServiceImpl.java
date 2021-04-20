package ru.savelchev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.savelchev.dao.DepartmentDAO;
import ru.savelchev.model.Department;

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


}
