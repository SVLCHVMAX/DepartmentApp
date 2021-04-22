package ru.savelchev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.savelchev.model.Department;
import ru.savelchev.model.Employee;
import ru.savelchev.service.DepartmentService;
import ru.savelchev.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/staff")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @GetMapping("/list")
    public String showAll(Model model) {
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("staff",employeeList);
        return "list-staff";

    }

    @GetMapping("/{id}")
    public String showStaff(@PathVariable("id") int id, Model model) {
        Department department = departmentService.findById(id);
        List<Employee> employeeList = department.getEmployeeList();
        model.addAttribute("staff",employeeList);
        model.addAttribute("department",department);
        return "list-staff-department";
    }

    @GetMapping("/new")
    public String newEmployee(@ModelAttribute("employee") Employee employee) {
        return "new-employee";
    }

    @PostMapping
    public String createEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/staff/list";
    }

}
