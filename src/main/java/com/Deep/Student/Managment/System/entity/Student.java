package com.Deep.Student.Managment.System.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = " students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    private String lastName;

    private String email;

}
