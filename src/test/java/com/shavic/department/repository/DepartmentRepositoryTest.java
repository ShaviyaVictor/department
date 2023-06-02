package com.shavic.department.repository;

import com.shavic.department.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

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

}