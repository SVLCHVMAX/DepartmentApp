package ru.savelchev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.savelchev.model.Department;
import ru.savelchev.model.Employee;
import ru.savelchev.service.DepartmentService;
import ru.savelchev.service.EmployeeService;

import javax.validation.Valid;
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
    public String create(@ModelAttribute("department") @Valid Department department, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        departmentService.save(department);
        return "redirect:/department/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        departmentService.deleteDepartment(id);
        return "redirect:/department/list";
    }

}
