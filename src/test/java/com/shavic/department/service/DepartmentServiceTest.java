package com.shavic.department.service;

import com.shavic.department.entity.Department;
import com.shavic.department.exception.DepartmentNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void whenValidDepartment_thenDepartmentShouldBeFound() throws DepartmentNotFoundException {

//        defining the expected value
        String departmentName = "Group IT";
//        calling the method being tested thru the autowired layer that contains the method being tested
        Optional<Department> nameFound = departmentService.fetchDepartmentByName(departmentName);
//        validate the values against each other, the expected value against the value found in the object returned form the test method call
        assertEquals(departmentName, nameFound.stream());

    }

}