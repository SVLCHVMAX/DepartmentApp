package ru.savelchev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.savelchev.dao.EmployeeDAO;
import ru.savelchev.model.Employee;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    @Override
    @Transactional
    public List<Employee> getStaff(int departmentId) {
        return employeeDAO.getStaff(departmentId);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String birthday = dateFormat.format(employee.getBirthday());
        try {
            employee.setBirthday(dateFormat.parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }

    @Override
    @Transactional
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
