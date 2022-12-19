package com.develhope.crudtest.service;

import com.develhope.crudtest.entities.Student;
import com.develhope.crudtest.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student setStudentWorkStatus(Long id, boolean isWorking){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            student.get().setWorking(isWorking);
            studentRepository.saveAndFlush(student.get());
        }
        return null;
    }
}
