package com.shavic.department.repository;

import com.shavic.department.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {

        Department department = Department.builder()
                .departmentName("Group HR")
                .departmentHead("Brian")
                .departmentRole("Human Resources")
                .build();

        testEntityManager.persist(department);

    }

    @Test
    @DisplayName("FindById Method Test-case: happy case")
    public void whenFindById_thenReturnDepartment() {

        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "Group HR");

    }

    @Test
    @DisplayName("fetchByDepartmentName Method Test-case: happy case")
//    @Disabled
    public void whenFetchByDepartmentName_thenReturnDepartment() {

        Department department = departmentRepository.findByDepartmentNameIgnoreCase("Group HR");
        assertEquals(department.getDepartmentName(), "Group HR");

    }

}