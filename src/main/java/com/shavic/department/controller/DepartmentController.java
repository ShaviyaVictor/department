package com.shavic.department.controller;

import com.shavic.department.entity.Department;
import com.shavic.department.exception.DepartmentNotFoundException;
import com.shavic.department.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The REST Controller that defines the various API's(CRUD operations for the app)
 */
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);

//    Post to Department Table Entity
    @PostMapping("/add/department")
    public Department saveDepartment(@Valid @RequestBody Department department) {
//        1st way of creating the service object
//        DepartmentService departmentService = new DepartmentServiceImpl();
//                or
//        var departmentService = new DepartmentServiceImpl();
        log.info("\n\nYeah, the POST request has been actioned!\n");
        return departmentService.saveDepartment(department);
    }

//    Get all departments
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        return departmentService.fetchDepartmentList();
    }

//    Get department by Id
    @GetMapping("/departmentById/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

//    Delete department by Id
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
//        return a String print on the console for successful operation
        return "Department deleted successful!";
    }

//    Update Department
    @PutMapping("/update/department/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department) throws DepartmentNotFoundException {
        return departmentService.updateDepartment(departmentId, department);
    }

//    Get department by name
//    Getting this error with current setup: https://stackoverflow.com/questions/35155916/handling-ambiguous-handler-methods-mapped-in-rest-application-with-spring
//    Adding a difference in the path URL to avoid the ambiguity
    @GetMapping("/departmentByName/{name}")
    public Optional<Department> fetchDepartmentByName(@PathVariable("name") String departmentName) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
