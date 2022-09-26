//package com.list.controller;
//
//
//import com.list.dto.SchoolDto;
//import com.list.dto.TeachersDto;
//import com.list.mappingsEntity.School;
//import com.list.mappingsEntity.Teacher;
//import com.list.repository.MappingSchoolRepo;
//import com.list.repository.MappingsStudentsRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//public class MappingsController {
//
//    @Autowired
//    private MappingSchoolRepo schoolRepo;
//
//    @Autowired
//    private MappingsStudentsRepo studentsRepo;
//
//    @PostMapping("school-student")
//    public void OneToManyDemo(@RequestBody SchoolDto dto){
//        School school = new School();
//        school.setSchoolName(dto.getSchoolName());
//        school.setAddress(dto.getAddress());
//List<Teacher> teacherList = new ArrayList<>();
//        List<TeachersDto> studentsDtos = dto.getTeachersDtos();
//
//        studentsDtos.stream().forEach(i ->{
//            Teacher teacher = new Teacher();
//            teacher.setStandard(i.getStandard());
//            teacher.setTeacher(i.getTeacher());
//            teacherList.add(teacher);
//        } );
//
//
//        school.setTeacher(teacherList);
//       schoolRepo.save(school);
//
//    }
//
//}
