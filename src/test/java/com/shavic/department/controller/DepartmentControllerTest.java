package com.shavic.department.controller;

import com.shavic.department.entity.Department;
import com.shavic.department.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department outputtedDepartment;

    @BeforeEach
    void setUp() {

//        Output POJO Object
        outputtedDepartment = Department.builder()
                .departmentId(1L)
                .departmentName("Grp IT")
                .departmentHead("Shaviya")
                .departmentRole("IT services")
                .build();

    }

    @Test
    @DisplayName("Save method happy scenario Test Case")
    void saveDepartment() throws Exception {

//        Expected Input POJO Object - won't have the ID since that property is AutoGenerated
        Department inputtedDepartment = Department.builder()
                .departmentName("Grp IT")
                .departmentHead("Shaviya")
                .departmentRole("IT services")
                .build();

//        mock the object for persistence during the test
        Mockito.when(departmentService.saveDepartment(inputtedDepartment))
                .thenReturn(outputtedDepartment);

//        use the Autowired final class to make the Endpoint call
        /*
        Using the long Static class names from the MockMvc class for the builders and matchers
        * mockMvc.perform(MockMvcRequestBuilders.post("/add/department")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"departmentName\":\"Grp IT\",\n" +
                        "\t\"departmentHead\":\"Shaviya\",\n" +
                        "\t\"departmentRole\":\"IT services\",\n" +         // this comma here will make the test to FAIL
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
         */

//        After Adding the on-demand Static import to shorten the Request and Result class name:
//        Using the ALT + ENTER keyboard shortcut keys
        mockMvc.perform(post("/add/department")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"departmentName\":\"Grp IT\",\n" +
                        "\t\"departmentHead\":\"Shaviya\",\n" +
                        "\t\"departmentRole\":\"IT services\"\n" +
                        "}"))
                .andExpect(status().isOk());

    }

    @Test
    void fetchDepartmentById() {
    }

}