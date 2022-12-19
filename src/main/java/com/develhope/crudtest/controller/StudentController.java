package com.develhope.crudtest.controller;

import com.develhope.crudtest.entities.Student;
import com.develhope.crudtest.repositories.StudentRepository;
import com.develhope.crudtest.service.StudentService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    private StudentRepository studentRepository;

    @PostMapping("/")
    public void create(@RequestBody Student student){
        studentRepository.save(student);

    };

    @GetMapping("/")
    public List<Student> getList(){
        return studentRepository.findAll();
    };

    @GetMapping("/{id}")
    public Student getSingle(@PathVariable Long id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();
        }else {
            return null;
        }
    };

    @PutMapping("/")
    public void update(@PathVariable Long id, @RequestBody @NotNull Student student){
        student.setId(id);
        studentRepository.save(student);
    };

    @PutMapping("/{id}/work")
    public void SetWork(@PathVariable Long id,@RequestParam("isWorking") boolean isWorking){
        studentService.setStudentWorkStatus(id, isWorking);
    };

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        studentRepository.deleteById(id);
    };

}
