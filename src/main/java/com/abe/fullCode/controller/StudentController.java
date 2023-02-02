package com.abe.fullCode.controller;

import com.abe.fullCode.model.Student;
import com.abe.fullCode.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentServices;

//ADDING STUDENT INTO DATABASE
    @PostMapping ("/saveStudent")
    public String saveStudent(Student student){
        studentServices.addStudent(student);
        return "redirect:/";
    }
//    DISPLAY STUDENT INTO TABLE
    @GetMapping("/")
    public String getAll(Model model){
        model.addAttribute("studentList",studentServices.getAll());
        return "abe";
    }
//    DISPLAY BY ID
    @RequestMapping("/getById")
    @ResponseBody
    public Optional<Student> getById(Integer stuId){
        return studentServices.getStudentById(stuId);
    }

@GetMapping("/delete")
    public String delete(Integer stuId){
        studentServices.deleteMe(stuId);
        return ("redirect:/");
}

    }
