package ru.savelchev.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.savelchev.model.Department;
import ru.savelchev.model.Employee;

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

    @Override
    public void deleteDepartment(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Department where id = :departmentId");
        query.setParameter("departmentId",id);
        query.executeUpdate();
    }

    @Override
    public List<Employee> getEmployees(int id) {
        Session session = sessionFactory.getCurrentSession();
        Department department = session.get(Department.class,id);
        return department.getEmployeeList();
    }

    @Override
    public void addEmployee(Employee employee) {

    }

    @Override
    public Department findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Department.class,id);
    }
}
