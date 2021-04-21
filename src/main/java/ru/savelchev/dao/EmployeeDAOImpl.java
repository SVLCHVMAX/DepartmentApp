package ru.savelchev.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.savelchev.model.Department;
import ru.savelchev.model.Employee;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Employee> getStaff(int id) {

        System.out.println(id);

        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("from Employee where department=:id", Employee.class);
        query.setParameter("id", id);
        List<Employee> employeeList = query.getResultList();
        return employeeList;
    }
}
