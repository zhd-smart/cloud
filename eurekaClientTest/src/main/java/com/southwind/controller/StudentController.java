package com.southwind.controller;

import com.netflix.discovery.converters.Auto;
import com.southwind.entity.Student;
import com.southwind.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping(value = "/student")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Value(value = "${server.port}")
    private String port;

    @GetMapping(value = "/findAll")
    public Collection<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping(value = "/findById/{id}")
    public Student findById(@PathVariable("id") long stuId){
        return studentService.fingById(stuId);
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody Student student){
        studentService.saveOrupdate(student);
    }

    @PutMapping(value = "/update")
    public void update(@RequestBody Student student){
        studentService.saveOrupdate(student);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") long stuId){
        studentService.deleteById(stuId);
    }

    @GetMapping(value = "/index")
    public String index(){
        return "当前的端口：" + this.port;
    }
}
