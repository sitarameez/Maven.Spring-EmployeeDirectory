package io.zipcoder.persistenceapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public Department createDept(Department department) {
        return departmentRepository.save(department);
    }

    public Department read(Long id) {
        return departmentRepository.findOne(id);
    }

    public Iterable<Department> readAll() {
        return departmentRepository.findAll();
    }

    public Department update(Long id, Department newInfo) {
        Department department = read(id);
        department.setDepartmentName(newInfo.getDepartmentName());
        departmentRepository.save(department);
        return department;
    }

    public Department delete(Long id) {
        return delete(read(id));
    }

    public Department delete(Department department) {
        departmentRepository.delete(department);
        return department;
    }

}
