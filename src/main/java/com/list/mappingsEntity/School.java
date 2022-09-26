//package com.list.mappingsEntity;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Data
//public class School {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    private String schoolName;
//    private String address;
//
//    @OneToMany(cascade = CascadeType.ALL)
//
//    private List<Teacher> teacher;
//}
