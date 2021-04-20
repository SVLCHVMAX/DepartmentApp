package ru.savelchev.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.savelchev.model.Department;

import java.util.List;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Department> getDepartments() {

        Session session = sessionFactory.getCurrentSession();
        Query<Department> query = session.createQuery("from Department order by departmentName",Department.class);
        List<Department> departments = query.getResultList();

        return departments;
    }

    @Override
    public void save(Department department) {

        Session session = sessionFactory.getCurrentSession();
        session.save(department);
    }
}
