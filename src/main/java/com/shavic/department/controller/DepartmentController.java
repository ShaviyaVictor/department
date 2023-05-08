package com.shavic.department.controller;

import com.shavic.department.entity.Department;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @PostMapping("/departments")
    public Department saveDepartment() {

    }

}
