package com.list.dto;

import com.list.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class RequestDto {
    private String name;
    private String country;
    private String subject;
    private List<DesignRequest> desig;
    private List<String> course;


}
