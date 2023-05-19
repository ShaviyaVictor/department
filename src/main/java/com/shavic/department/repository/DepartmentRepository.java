package com.shavic.department.repository;

import com.shavic.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Spring_Docs:
//      https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords
//      https://docs.spring.io/spring-data/jpa/docs/current/reference/html/


@Repository
//JpaRepository takes in the Entity Object and the Primary Key Type
public interface DepartmentRepository extends JpaRepository<Department, Long> {

//    Modifier 'public' is redundant for interface members hence no initializing the methods in Interfaces with public declaration
    Department findByDepartmentName(String departmentName);

//    to loosen the check on the name by ignoring the Case checks we add the Keyword: IgnoreCase in our custom method
//    and now with the below method call, as long as the method matches an object in the DB, regardless of the case mismatch, the results will be found
    Department findByDepartmentNameIgnoreCase(String departmentName);

//    For complex queries, you can also use the @Query() annotation and pass your SQL query statement within the parenthesis and create the custom method below it

}
