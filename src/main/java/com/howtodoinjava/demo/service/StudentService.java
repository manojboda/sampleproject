package com.howtodoinjava.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.model.StudentEntity;
import com.howtodoinjava.demo.repository.StudentRepository;
 
@Service
public class StudentService {
     
    @Autowired
    StudentRepository repository;
     
    public List<StudentEntity> getAllStudent()
    {
        List<StudentEntity> studentList = repository.findAll();
         
        if(studentList.size() > 0) {
            return studentList;
        } else {
            return new ArrayList<StudentEntity>();
        }
    }
     
    public StudentEntity getStudentById(Long id) throws RecordNotFoundException
    {
        Optional<StudentEntity> student = repository.findById(id);
         
        if(student.isPresent()) {
            return student.get();
        } else {
            throw new RecordNotFoundException("No student record exist for given id");
        }
    }
     
    public StudentEntity createOrUpdateStudent(StudentEntity entity) throws RecordNotFoundException
    {
//        Optional<StudentEntity> student = repository.findById(entity.getId());
//         
//        if(student.isPresent())
//        {
//            StudentEntity newEntity = student.get();
//            newEntity.setId(entity.getId());
//            newEntity.setAge(entity.getAge());
//            newEntity.setGmail(entity.getGmail());
//            newEntity.setFirstName(entity.getFirstName());
//            newEntity.setLastName(entity.getLastName());
// 
//            newEntity = repository.save(newEntity);
//             
//            return newEntity;
//        } else {
            entity = repository.save(entity);
             
            return entity;
//        }
    }
     
    public void deleteStudentById(Long id) throws RecordNotFoundException
    {
        Optional<StudentEntity> student = repository.findById(id);
         
        if(student.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No student record exist for given id");
        }
    }
}