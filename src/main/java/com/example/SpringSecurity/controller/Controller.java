package com.example.SpringSecurity.controller;

import com.example.SpringSecurity.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    List<Student> list = new ArrayList<Student>(List.of(new Student(101,"Vaibhav",69), new Student(102,"Jatin",79)));

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/students")
    public List<Student> students(){
        return list;
    }

    @PostMapping("/add")
    public void addStudent(@RequestBody Student s){
        list.add(s);
    }

    @GetMapping("/csrf")
    public CsrfToken token(HttpServletRequest request){
           return (CsrfToken) request.getAttribute("_csrf");
    }
}
