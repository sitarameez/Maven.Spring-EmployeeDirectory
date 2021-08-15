package io.zipcoder.persistenceapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping(value = "/create-dept")
    ResponseEntity<Department>createDept(@RequestBody Department department){
       return new ResponseEntity<>(departmentService.createDept(department), HttpStatus.CREATED);
    }
    @GetMapping(value = "/read/{id}")
    ResponseEntity<Department>read(@RequestBody Long id){
        return new ResponseEntity<>(departmentService.read(id),HttpStatus.OK);
    }
    @GetMapping(value = "/readAll")
    ResponseEntity<Iterable<Department>>readAll(){
        return new ResponseEntity<>(departmentService.readAll(),HttpStatus.OK);
    }
    @PutMapping(value = "/update/{id}")
    ResponseEntity<Department>update(@PathVariable Long id,@RequestBody Department department){
        return new ResponseEntity<>(departmentService.update(id,department),HttpStatus.OK);
    }
    @DeleteMapping(value = "/delete/{id}")
    ResponseEntity<Department>delete(@PathVariable Long id){
        return new ResponseEntity<>(departmentService.delete(id),HttpStatus.OK);
    }



}
