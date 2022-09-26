package com.list.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue
    private int id;
    private String course;

@ManyToOne
@JoinColumn(name = "institue_id")
private Institue institue;;

}
