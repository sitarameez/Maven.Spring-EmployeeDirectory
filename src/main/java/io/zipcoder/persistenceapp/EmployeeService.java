package io.zipcoder.persistenceapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee read(Long id){
        return employeeRepository.findOne(id);
    }
    public Iterable<Employee> readAll(){
        return employeeRepository.findAll();
    }

    public Employee update(Long id,Employee newInfo){
       Employee e=read(id);
       e.setFirstName(newInfo.getFirstName());
       e.setLastName(newInfo.getLastName());
       employeeRepository.save(e);
       return e;
    }

    public Employee delete(Long id){
        return delete(read(id));
    }
    public Employee delete(Employee employee){employeeRepository.delete(employee);return employee;}
}
