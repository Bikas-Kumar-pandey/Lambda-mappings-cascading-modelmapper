package com.list.repository;

import com.list.dto.SampleInterface;
import com.list.entity.Employee;
import com.list.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SampleRepo extends JpaRepository<Employee,Integer> {
    @Query(nativeQuery = true,value = "SELECT s.id  Id,s.country Country , e.course Course from employees e Left join student s  on s.id = e.sid  ")
    List<SampleInterface> twoTableValues();

//    @Query(nativeQuery = true,value = "SELECT s.id  Id,s.country Country , e.course Course from employees e Left join student s  on s.id = e.sid  ")
//    List<SampleInterface> twoTableValues();
}
