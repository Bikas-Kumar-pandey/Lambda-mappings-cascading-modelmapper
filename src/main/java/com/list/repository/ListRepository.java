package com.list.repository;

import com.list.dto.SampleInterface;
import com.list.entity.Employee;
import com.list.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ListRepository extends JpaRepository<Student, Integer > {
    List<Student> findAllById(int id);

    Student findByName(String name);


}
