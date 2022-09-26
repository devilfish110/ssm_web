package org.study.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.study.entities.Student;
import org.study.service.StudentService;

import java.util.List;

@Controller("StudentController")
@RequestMapping({"/student"})
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping({"/all"})
    @ResponseBody
    public List<Student> AllStu() {
        return studentService.getAllStu();
    }

    @PostMapping({"/addStudent"})
    @ResponseBody
    public Boolean addStudent(@Valid Student student) {
        return studentService.addOneStudent(student);
    }

    @DeleteMapping({"/delStudent"})
    @ResponseBody
    public Boolean delStudent(@RequestBody String jsonData) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = objectMapper.readValue(jsonData, Student.class);
        return studentService.delOneStudent(student);
    }

    @PutMapping({"/updateStudent"})
    @ResponseBody
    public Boolean updateStudent(@RequestBody String jsonData) throws JsonProcessingException {
        //System.out.println(jsonData);
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = objectMapper.readValue(jsonData, Student.class);
        //System.out.println(student);
        return studentService.updateStudent(student);
    }
}

