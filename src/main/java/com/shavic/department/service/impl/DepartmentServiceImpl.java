package com.shavic.department.service.impl;

import com.shavic.department.entity.Department;
import com.shavic.department.exception.DepartmentNotFoundException;
import com.shavic.department.repository.DepartmentRepository;
import com.shavic.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Service Class Implementation that defines the main logic
 *
 */
@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {

//    there isn't a difference from my tests so far btwn having plainly calling the Autowired class,
//    and calling it as a private class like we did in the Controller layer
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        log.info("\n\nSaving Department Object!\n");
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        log.info("\n\nRetrieving Department List!\n");
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {

//        1.) fetching data without any exception handling
//        return departmentRepository.findById(departmentId).get();

//        2.) fetching data while handling an exception(NotFound)
        Optional<Department> department = departmentRepository.findById(departmentId);
//        check if the new department object has value of not
        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department with ID - " + departmentId + " is NOT present!");
        }
        log.info("\n\nFetching Department Object by ID - " + departmentId + "\n");
        return department.get();

    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        log.info("\n\nDeleting Department Object by ID - " + departmentId + "\n");
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) throws DepartmentNotFoundException {

//        get the object Entity of the specified Id from the DB
//        Department departmentObject = departmentRepository.findById(departmentId).get();

//        Logic trial to throw an exception when updating an object that is npt present - is working!! Thank You Jesus!
//        !departmentObject1.isPresent() == departmentObject1.isEmpty()
        Optional<Department> departmentObject1 = departmentRepository.findById(departmentId);
        if (departmentObject1.isEmpty()) {
            throw new DepartmentNotFoundException("Department with ID - " + departmentId + " is NOT present for an UPDATE to occur");
        }
        Department departmentObject = departmentObject1.get();

//        logic to check the Entity properties that are null in the incoming changes and if null, skip;
//        and if an update is present, then update the specified object

//        if departmentName is NOT NULL and is also not blank as well as equals to the available departmentName ignoring the casing;
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

        log.info("\n\nUpdating Department Object by ID - " + departmentId + "\n");

        return departmentRepository.save(departmentObject);

    }

    @Override
    public Optional<Department> fetchDepartmentByName(String departmentName) throws DepartmentNotFoundException {
        log.info("\n\nFetching Department Object by Name - " + departmentName + "\n");
//        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
        
//        logic to throw an exception when trying to find a departmentByName for an Object that does not exist
        Optional<Department> department = departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
        if (department.isEmpty()) {
            throw new DepartmentNotFoundException("Department with ID - " + departmentName + " is NOT present!");
        }
        return department;
        
    }

}
