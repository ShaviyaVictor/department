package com.shavic.department.service.impl;

import com.shavic.department.entity.Department;
import com.shavic.department.repository.DepartmentRepository;
import com.shavic.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

//    there isn't a difference from my tests so far btwn having plainly calling the Autowired class,
//    and calling it as a private class like we did in the Controller layer
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
//        get the object Entity of the specified Id from the DB
        Department departmentObject = departmentRepository.findById(departmentId).get();
//        logic to check the Entity properties that are null in the incoming changes and if null, skip;
//        and if an update is present, then update the specified object

//        if departmentName is NOT NULL and is also not blank equals to the available departmentName ignoring the casing;
//        then skip the departmentName or in other words let the same available value remain.
//        Same logic check for the other Entity properties: departmentHead and departmentRole
        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            departmentObject.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(department.getDepartmentHead()) && !"".equalsIgnoreCase(department.getDepartmentHead())) {
            departmentObject.setDepartmentHead(department.getDepartmentHead());
        }
        if (Objects.nonNull(department.getDepartmentRole()) && !"".equalsIgnoreCase(department.getDepartmentRole())) {
            departmentObject.setDepartmentRole(department.getDepartmentRole());
        }

        return departmentRepository.save(departmentObject);

    }

}
