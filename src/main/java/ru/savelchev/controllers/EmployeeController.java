package ru.savelchev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.savelchev.model.Employee;
import ru.savelchev.service.DepartmentService;
import ru.savelchev.service.EmployeeService;

@Controller
@RequestMapping("/department/staff/")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @GetMapping("/new")
    public String newEmployee(@ModelAttribute("employee")Employee employee) {
        return "new-employee";
    }

    @PostMapping
    public String createEmployee(@ModelAttribute("employee") Employee employee) {
        departmentService.addEmployee(employee);
        return "redirect:/department/staff";
    }

}
