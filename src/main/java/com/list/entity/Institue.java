package com.list.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data


public class Institue {
    @Id
    @GeneratedValue
    private int id;
    private String institute;

    @OneToMany
    private List<Course> courses;
}
