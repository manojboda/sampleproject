package com.howtodoinjava.demo.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.model.StudentEntity;
import com.howtodoinjava.demo.service.StudentService;
 
@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController
{
    @Autowired
    StudentService service;
 
    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAllEmployees() {
        List<StudentEntity> list = service.getAllStudent();
 
        return new ResponseEntity<List<StudentEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getEmployeeById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        StudentEntity entity = service.getStudentById(id);
 
        return new ResponseEntity<StudentEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<StudentEntity> createOrUpdateStudent(@RequestBody StudentEntity student)
                                                    throws RecordNotFoundException {
        StudentEntity updated = service.createOrUpdateStudent(student);
        return new ResponseEntity<StudentEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deleteStudentById(id);
        return new ResponseEntity<String>("SUccesfully Deleted", new HttpHeaders(), HttpStatus.OK);
    }
 
}