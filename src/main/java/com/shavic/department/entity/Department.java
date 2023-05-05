package com.shavic.department.entity;

public class Department {

    private Long departmentId;
    private String departmentName;
    private String departmentHead;
    private String departmentRole;

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
}
