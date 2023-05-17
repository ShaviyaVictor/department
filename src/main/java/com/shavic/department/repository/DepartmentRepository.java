package com.shavic.department.repository;

import com.shavic.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//JpaRepository takes in the Entity Object and the Primary Key Type
public interface DepartmentRepository extends JpaRepository<Department, Long> {

//    Modifier 'public' is redundant for interface members hence no initializing the methods in Interfaces with public declaration
    Department findByDepartmentName(String departmentName);

}
