package com.develhope.crudtest.repositories;
import com.develhope.crudtest.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
