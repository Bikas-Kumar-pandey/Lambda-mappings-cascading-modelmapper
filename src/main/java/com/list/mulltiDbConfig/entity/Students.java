package com.list.mulltiDbConfig.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Students {
    @Id
    private String id;
}
