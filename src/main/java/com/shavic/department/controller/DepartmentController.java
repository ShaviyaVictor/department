package com.shavic.department.controller;

import com.shavic.department.entity.Department;
import com.shavic.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

//    Post all departments
    @PostMapping("/add/department")
    public Department saveDepartment(@RequestBody Department department) {
//        1st way of creating the service object
//        DepartmentService departmentService = new DepartmentServiceImpl();
//                or
//        var departmentService = new DepartmentServiceImpl();
        return departmentService.saveDepartment(department);
    }

//    Get all departments
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        return departmentService.fetchDepartmentList();
    }

//    Get department by Id
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) {
        return departmentService.fetchDepartmentById(departmentId);
    }

}
