package com.shavic.department.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * JPA Department Entity with 4 fields/properties
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {

//    Entity properties
//    more VALIDATION RESOURCES - check HelloWorld file on Hibernate Validations section
//      https://www.geeksforgeeks.org/spring-boot-validation-using-hibernate-validator/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    @NotBlank(message = "Please add the department name")
//    @Size(min = 5, message = "The Name should be at least 5 characters")
//    @Size(max = 16, message = "The Name should at most be 16 characters")
    @Size(min = 5, max = 16, message = "The Name should be between a character count of 5 - 16 characters")
    private String departmentName;
    private String departmentHead;
    private String departmentRole;

    //    Getters and Setters for the pro perties
    /*

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

    */

//    constructors for the Entity properties
    /*

    public Department(Long departmentId, String departmentName, String departmentHead, String departmentRole) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentHead = departmentHead;
        this.departmentRole = departmentRole;
    }

    */

//    default constructor
    /*

    public Department() {
    }

    */

//    call toString() method for the properties
    /*

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentHead='" + departmentHead + '\'' +
                ", departmentRole='" + departmentRole + '\'' +
                '}';
    }

    */

}
