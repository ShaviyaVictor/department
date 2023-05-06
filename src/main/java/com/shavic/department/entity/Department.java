package com.shavic.department.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Department {

//    Entity properties
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    private String departmentName;
    private String departmentHead;
    private String departmentRole;

    //    Getters and Setters for the properties
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(String departmentHead) {
        this.departmentHead = departmentHead;
    }

    public String getDepartmentRole() {
        return departmentRole;
    }

    public void setDepartmentRole(String departmentRole) {
        this.departmentRole = departmentRole;
    }

//    constructors for the Entity properties
    public Department(Long departmentId, String departmentName, String departmentHead, String departmentRole) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentHead = departmentHead;
        this.departmentRole = departmentRole;
    }

//    default constructor
    public Department() {
    }

//    call toString() method for the properties
    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentHead='" + departmentHead + '\'' +
                ", departmentRole='" + departmentRole + '\'' +
                '}';
    }

}
