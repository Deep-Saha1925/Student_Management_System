package com.Deep.Student.Managment.System.service;

import com.Deep.Student.Managment.System.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudents();

    public Student saveStudent(Student student);

    public Student getById(int id);

    public void deleteById(int id);
}
