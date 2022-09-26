package com.list.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NewDto {
    @Id
    private int id;
    private String hello;
}
