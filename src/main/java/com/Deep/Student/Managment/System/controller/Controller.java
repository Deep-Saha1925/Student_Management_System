package com.Deep.Student.Managment.System.controller;

import com.Deep.Student.Managment.System.entity.Student;
import com.Deep.Student.Managment.System.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String home(){
        return "home";  //view page(home.html)
    }

    @GetMapping("/students")
    public String getAllStudents(Model model){

        model.addAttribute("students", studentService.getAllStudents());

        return "students";  //returned page(students.html)
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model){

        Student student = new Student();
        model.addAttribute("student", student);

        return "createStudent";
    }


    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){

        studentService.saveStudent(student);

        return "redirect:/students";
    }


    @GetMapping("/students/edit/{id}")
    public String editStudentInfo(@PathVariable int id, Model model){
        model.addAttribute("student", studentService.getById(id));

        return "editStudent";
    }


    @PostMapping("/students/edit/{id}")
    public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student){
        Student existingStudent = studentService.getById(id);

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        studentService.saveStudent(existingStudent);

        return "redirect:/students";
    }


    @GetMapping("/students/{id}")
    public String deleteById(@PathVariable int id){
        studentService.deleteById(id);

        return "redirect:/students";
    }
}
