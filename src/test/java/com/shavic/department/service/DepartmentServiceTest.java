package com.shavic.department.service;

import com.shavic.department.entity.Department;
import com.shavic.department.exception.DepartmentNotFoundException;
import com.shavic.department.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

//    Inject the service layer interface for the method call
    @Autowired
    private DepartmentService departmentService;

//    Inject the repository layer which should be mocked for data retrieval
    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {

//        Create the mock object which will be built before every method is run
        Department department = Department.builder()
                .departmentId(1L)
                .departmentName("Group IT")
                .departmentHead("Shaviya")
                .departmentRole("Software Engineering")
                .build();

//        tell Mockito to be providing the provided dummy data whenever the DAO method is called
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("Group IT"))
                .thenReturn((department));

    }

    @Test
    @DisplayName("Fetch Department by Name Happy Test-case ") //to allow a more readable name to be displayed on the console when the test runs
//    @Disabled //to disable a test from running
    public void whenValidDepartmentName_thenDepartmentShouldBeFound(){

//        defining the expected value
        String departmentName = "Group IT";
//        calling the method being tested thru the autowired layer that contains the method being tested
        Department nameFound = departmentService.fetchDepartmentByName(departmentName);

//        validate the values against each other, the expected value against the value found in the object returned form the test method call
        assertEquals(departmentName, nameFound.getDepartmentName());

    }

}

/**
 * * Tests were failing coz of the below DB configuration:
 *      *  #spring.jpa.properties.hibernate.dialect
 */

