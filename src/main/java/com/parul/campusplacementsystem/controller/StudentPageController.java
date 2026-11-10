package com.parul.campusplacementsystem.controller;

import com.parul.campusplacementsystem.entity.Student;
import com.parul.campusplacementsystem.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StudentPageController {

    @Autowired
    private StudentService studentService;

    // Show Student List
    @GetMapping("/student")
    public String studentList(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student-list";
    }

    // Open Add Student Form
    @GetMapping("/student/add")
    public String addStudentPage(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    // Save or Update Student with Validation
    @PostMapping("/student/save")
    public String saveStudent(
            @Valid Student student,
            BindingResult result) {

        if (result.hasErrors()) {
            return "student-form";
        }

        studentService.saveStudent(student);
        return "redirect:/student";
    }

    // Delete Student
    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "redirect:/student";
    }

    // Edit Student
    @GetMapping("/student/edit/{id}")
    public String editStudent(@PathVariable int id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student-form";
    }
}