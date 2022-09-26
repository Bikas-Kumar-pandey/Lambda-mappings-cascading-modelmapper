package com.list.dto;

import lombok.Data;
import java.util.List;

@Data
public class SchoolDto {

    private String schoolName;
    private String address;

   private List<TeachersDto> teachersDtos;



}
