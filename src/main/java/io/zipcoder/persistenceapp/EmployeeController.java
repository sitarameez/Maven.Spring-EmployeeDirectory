package io.zipcoder.persistenceapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee-controller")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = "/create-employee")
    ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping(value = "/read")
    ResponseEntity<Employee> read(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.read(id), HttpStatus.OK);
    }

    @GetMapping(value = "/read/{id}")
    ResponseEntity<Iterable<Employee>> readAll(@PathVariable Long id, @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.readAll(), HttpStatus.OK);
    }
    @PutMapping(value = "/update{id}")
    ResponseEntity<Employee> update(@PathVariable Long id,@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.update(id,employee),HttpStatus.OK);
    }
    @DeleteMapping(value = "/delete/{id}")
    ResponseEntity<Employee>delete(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.delete(id),HttpStatus.OK);
    }
}
