package io.zipcoder.persistenceapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String departmentName;
    Employee Manager;

    public Department(Long id, String departmentName, Employee manager) {
        this.id = id;
        this.departmentName = departmentName;
        Manager = manager;
    }

    public Department() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Employee getManager() {
        return Manager;
    }

    public void setManager(Employee manager) {
        Manager = manager;
    }
}
