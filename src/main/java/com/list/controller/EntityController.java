package com.list.controller;

import com.list.dto.*;
import com.list.entity.Institue;
import com.list.entity.Student;
import com.list.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EntityController {

    @Autowired
    private ListService listService;


    @PostMapping("/data")
    public void listDemo(@RequestBody RequestDto request){
        listService.listDemo(request);
        return;
    }

    @PostMapping("/path/{name}/{country}/{subject}")
    public void listDemoPathVariable(@PathVariable String name,@PathVariable String country,@PathVariable String subject ){
        listService.listDemoPath(name,country,subject);
    }

    @PostMapping("/list")
    public void saveAsList(@RequestBody RequestDto request){
        listService.saveAsList(request);
        return;
    }

    @PostMapping("/dtolist")
    public void saveAsListofDto(@RequestBody  List<RequestDto> request){
        listService.saveAsListofDto(request);
    }

    @PostMapping("/mapping-in-2-dto")
    public void mappings(@RequestBody RequestDto request){
        listService.mappings(request);
    }

    @PostMapping("/mapping-in-single-dto")
    public void mappingss(@RequestBody RequestDto request){
        listService.mappingss(request);
    }

    @PostMapping("/mapping-in-same-dto")
    public void allMappingInOne(@RequestBody RequestsDtos request){
        listService.mappingInSameDto(request);
    }

    @PostMapping("/model-mapper")
    public void modeMapper(@RequestBody RequestsDtos request){
        listService.modeMapper(request);
    }
    @GetMapping("/Byid/{id}")
    public Student dataUsingId(@PathVariable int id) throws Exception {
        return listService.dataUsingId(id);

    }
    @GetMapping("/aa/{id}")
    public void useOFforEach(@PathVariable int id){
        listService.useOFforEach(id);
    }
@GetMapping("mapping-headers")
public void usingMap( @RequestParam String name,@RequestParam String country){
        listService.usingMap(demo(name,country));
}
    public Map<String,String> demo(String name,String country){
        Map m = new HashMap();
        m.put("name",name);
        m.put("country",country);
           return m;
    }


    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") int id,
                                                 @RequestBody RequestDto student) throws Exception {
        return listService.updateStudent(id,student);
    }
    @PutMapping("/students/{name}")
    public Student updateStudentByName(@PathVariable(value = "name") String name,
                                       @RequestBody RequestDto student) throws Exception {
        return listService.updateStudentByName(name,student);
    }

    @PatchMapping("patch/{id}")
    public Student patchDemo(@PathVariable(value = "id")int id,  @RequestBody RequestDto student){
        return listService.patchDemo(id,student);

    }
    @DeleteMapping("/delete/{id}")
    public String deleteData(@PathVariable(value = "id")int id){
        return listService.deleteData(id);
    }

    @PostMapping("/all-mappings")
    public String allMapByHttp(@RequestBody List<DemoDto> requestDto){
        return listService.allMapDemo(requestDto);
        }

    @DeleteMapping("/deletemap/{id}")
    public String deleteMapByHttp(@PathVariable(value = "id")int id,@RequestBody List<DemoDto> requestDto){
        return listService.deleteMap(id);


    }
    @GetMapping("/values")
    public List<SampleInterface>  values(){
        return listService.values();
    }
    @GetMapping("/single/{id}")
    public RequestDto singlevalues(@PathVariable int id){
        return listService.SingleValues(id);
    }


    @GetMapping("/allCascade/{id}")
    public RequestDto allCascasde(@PathVariable int id) {
        return listService.allCascasde(id);

    }


    @PostMapping("/mapped")
    public Institue mappedBy(@RequestBody Institue dto){
        return listService.mappedBy(dto);
    }
}

