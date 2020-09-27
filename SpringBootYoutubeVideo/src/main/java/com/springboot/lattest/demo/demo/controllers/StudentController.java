package com.springboot.lattest.demo.demo.controllers;

import com.springboot.lattest.demo.demo.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.springboot.lattest.demo.demo.repository.StudentRepository;

import javax.validation.Valid;


@Controller
@RequestMapping("/students/")
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository){
        this.studentRepository =  studentRepository;
    }

    @GetMapping("signup")
    public String showUserForm(Student student){
        return "addStudent";
    }

    @GetMapping("list")
        public String listStudents(Model model){
         model.addAttribute("students", studentRepository.findAll());
         return "index";
    }


    // method to add a new user to the database
    @PostMapping("add")
    public String addNewStudents(@Valid  Student student, BindingResult result, Model model){
        // if there is student  object validation error
        if (result.hasErrors()){
            return "index";
        }
        // add the  user to the database
        studentRepository.save(student);
        return "redirect:list";
    }


    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model ){
        System.out.println("inside addnewStudents");

        Student student =  studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id"));
        model.addAttribute("student", student);
        return "updateStudent";
    }

    @PostMapping("edit/{id}")
    public String updateStudentRecord(@PathVariable("id") long id, @Valid Student student, BindingResult result,  Model model){
        // validate the student object
        if(result.hasErrors()){
            student.setId(id);
            return "updateStudent";
        }
        // check if the user exists
        Student studentRecord = studentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Invalid User Id"));
        // update the user record
        studentRepository.save(student);
        model.addAttribute("students", studentRepository.findAll());
        return "index";
    }


    // delete a student from the database
    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model){
        System.out.println("hello");
        // check if the user exist
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
         // delete the user record
        studentRepository.deleteById(id);
        // redirect the user tot he /list route
        return "redirect:list";
    }


}
