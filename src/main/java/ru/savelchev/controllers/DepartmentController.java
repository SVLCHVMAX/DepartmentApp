package ru.savelchev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.savelchev.model.Department;
import ru.savelchev.service.DepartmentService;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/list")
    public String listDepartments(Model model) {

        List<Department> departments = departmentService.getDepartments();

        model.addAttribute("departments", departments);

        return "list-departments";
    }

    @GetMapping("/new")
    public String newDepartment(@ModelAttribute("department") Department department) {
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("department") Department department) {
        departmentService.save(department);
        return "redirect:/department/list";
    }





}
