package com.shavic.department.service;

import com.shavic.department.entity.Department;
import com.shavic.department.exception.DepartmentNotFoundException;

import java.util.List;

/**
 * The Service Interface that takes in the CRUD methods from the Controller and pass them to the ServiceImpl Class
 *
 */
public interface DepartmentService {

    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department) throws DepartmentNotFoundException;

    Department fetchDepartmentByName(String departmentName);

}
