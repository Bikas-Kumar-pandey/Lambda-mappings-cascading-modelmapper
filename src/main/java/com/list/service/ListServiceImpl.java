package com.list.service;
import com.list.dto.*;
import com.list.entity.*;
import com.list.repository.InstituteRepo;
import com.list.repository.ListRepository;
import com.list.repository.SampleRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;


@Service

public class ListServiceImpl implements ListService {

    @Autowired
    private ListRepository repo;


    @Override
    public void listDemo(RequestDto request) {
        Student entity = new Student();
        entity.setCountry(request.getCountry());
        entity.setName(request.getName());
        ;
        entity.setSubject(request.getSubject());
        repo.save(entity);

    }

    @Override
    public void listDemoPath(String name, String country, String subject) {
        Student entity = new Student();
        entity.setName(name);
        entity.setCountry(country);
        entity.setSubject(subject);
        repo.save(entity);

    }

    @Override
    public void saveAsList(RequestDto request) {
        Student entity = new Student();
        List<Student> list = new ArrayList<>();
        List<RequestDto> list1 = new ArrayList<>();
        entity.setCountry(request.getCountry());
        entity.setName(request.getName());
        ;
        entity.setSubject(request.getSubject());
        list.add(entity);
        repo.saveAll(list);
    }

    @Override
    public void saveAsListofDto(List<RequestDto> request) {
        List<Student> list = new ArrayList<>();
        for (RequestDto requests : request) {
            Student entity = new Student();
            entity.setSubject(requests.getSubject());
            entity.setCountry(requests.getCountry());
            entity.setName(requests.getName());
            list.add(entity);
        }
        repo.saveAll(list);
    }

    @Override
    public void mappings(RequestDto request) {
        Student student = new Student();

        student.setName(request.getName());
        student.setSubject(request.getSubject());
        student.setCountry(request.getCountry());
        List<Employee> list = new ArrayList<>();
        List<DesignRequest> designation = request.getDesig();
        for (DesignRequest designations : designation) {
            Employee employee = new Employee();
            employee.setDesignation(designations.getDesignation());
            list.add(employee);
        }
        student.setEmployee(list);
        repo.save(student);
    }

    @Override
    public void mappingss(RequestDto request) {
        Student student = new Student();
        student.setName(request.getName());
        student.setSubject(request.getSubject());
        student.setCountry(request.getCountry());
        List<Employee> list = new ArrayList<>();
        List<String> course = request.getCourse();
        for (String courses : course) {
            Employee employee = new Employee();
            employee.setCourse(courses);
            list.add(employee);
        }
        student.setEmployee(list);
        repo.save(student);
    }

    @Override
    public void mappingInSameDto(RequestsDtos request) {
        Student student = new Student();
        List<Employee> list = new ArrayList<>();
        List<Student> studentList = new ArrayList<>();

        student.setName(request.getName());
        student.setSubject(request.getSubject());
        student.setCountry(request.getCountry());

        List<Dtos> dtos = request.getDtos();
        for (Dtos requestsDtos : dtos) {
            Employee employee = new Employee();
            employee.setDesignation(requestsDtos.getDesig());
            employee.setCourse(requestsDtos.getCourse());
            list.add(employee);
        }
        student.setEmployee(list);
        repo.save(student);
    }

    @Override
    public Student dataUsingId(int id) throws Exception {

        Optional<Student> byId = repo.findById(id);
        if (!byId.isPresent()) {
            throw new Exception("doesnot Exists");

        }
        Student student = byId.get();
        System.out.println(student.getEmployee());
        System.out.println(student.getCountry());
        System.out.println(student.getName());
        return student;

    }

    @Override
    public void usingMap(Map<String, String> demo) {

        demo.get("name");
        demo.get("country");
        System.out.println(demo.get("name"));
        System.out.println(demo.get("country"));

    }

    @Override
    public void modeMapper(RequestsDtos request) {
        List<Employee> employeeList = new ArrayList<>();
        ModelMapper modelMaper = new ModelMapper();
        Student map = modelMaper.map(request, Student.class);
        List<Dtos> dtos = request.getDtos();
        for (Dtos dtos1 : dtos) {
            Employee employee = new Employee();
            employee.setCourse(dtos1.getCourse());
            employee.setDesignation(dtos1.getDesig());
            employeeList.add(employee);
        }
        map.setEmployee(employeeList);
        repo.save(map);
    }

    @Override
    public void useOFforEach(int id) {
        List<Student> allById = repo.findAllById(id);
//        allById.stream().filter(i -> i)
        allById.forEach(obj -> {
            obj.getCountry();
        });
        System.out.println(allById);
    }

    public void isValid(int id) throws Exception {
        if (!repo.existsById(id)) {
            throw new Exception("Does not Exists");
        }
    }

    @Override
    public ResponseEntity<Student> updateStudent(int id, RequestDto student) throws Exception {
        Student emp = repo.findById(id)
                .orElseThrow(() -> new Exception("Employee not found for this id :: " + id));
//        Student students = new Student();
        emp.setName(student.getName());
        Student save = repo.save(emp);
        return ResponseEntity.ok(save);
    }

    @Override
    public Student updateStudentByName(String name, RequestDto student) {
        Student names = repo.findByName(name);
        names.setCountry(student.getCountry());
        Student save = repo.save(names);
        return save;
    }

    @Override
    public String deleteData(int id) {
        repo.deleteById(id);
        return "Deleted";
    }

    @Override
    public Student patchDemo(int id, RequestDto students) {
        Optional<Student> byId = repo.findById(id);
        repo.findById(id);
        ;
        Student student = byId.get();
        student.setCountry(students.getCountry());
        return repo.save(student);
    }

    @Override
    public String allMapDemo(List<DemoDto> requestDto) {
        Student student = new Student();
        MToO mToO = new MToO();
        student.setName("bikas");

        List<MToM> mToMList = new ArrayList<>();
        for (DemoDto dto : requestDto) {
            MToM mToM = new MToM();
            OToO oToO = new OToO();
            oToO.setDemos(dto.getDemo());
            mToM.setDemo(dto.getDemo());

            mToMList.add(mToM);

            OToO oto = new OToO();
            oto.setDemos(dto.getDemo());


            mToO.setDemo(dto.getDemo());
            student.setOneToOne(oToO);

        }
        student.setManyToMany(mToMList);
        student.setManyToOnes(mToO);


        repo.save(student);
        return "saved";
    }

    @Override
    public String deleteMap(int id) {
        repo.deleteById(id);
        return "deleted";
    }

    @Autowired
    private SampleRepo sampleRepo;

    @Override
    public List<SampleInterface> values() {
        List<SampleInterface> sampleInterfaces = sampleRepo.twoTableValues();
        return sampleInterfaces;
    }

    @Override
    public RequestDto SingleValues(int id) {
        Optional<Student> byId = repo.findById(id);
        RequestDto dto = new RequestDto();
        if (byId.isPresent()) {
            Student student = byId.get();
            dto.setSubject(student.getSubject());
            dto.setCountry(student.getCountry());
        }
       return  dto;
    }

    @Override
    public RequestDto allCascasde(int id) {
        RequestDto dto = new RequestDto();
        Optional<Student> byId = repo.findById(id);
        Student student = byId.get();
        System.out.println("student.getName()");
        dto.setName(student.getName());;
        return dto;
    }

    @Autowired
    private InstituteRepo instituteRepo;

    public Institue mappedBy(Institue dto) {
//        Institue institue = new Institue();
//       List<Course> c = new ArrayList<>();
//
//        List<String> courses = dto.getCourse();
//        for (String coursess:courses){
//            Course course = new Course();
//            course.setCourse(coursess);
//            c.add(course);
//        }
//        institue.setCourses(c);
//        institue.setInstitute(dto.getInstitute());

        return instituteRepo.save(dto);


    }


}
