package com.southwind.controller;

import com.southwind.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping(value = "/rest")
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    //一个微服务去请求另一个微服务的方法，直接用restTemplate.getForEntity()返回一个ResponseEntity  .getBody()返回collert<>
    @GetMapping(value = "/findAll")
    public Collection<Student> findAll(){
        return restTemplate.getForEntity("http://localhost:8010/student/findAll",Collection.class).getBody();
    }

    //方法二：直接用restTemplate.getForObject()它的返回值类型是一个泛型
    @GetMapping(value = "/findAll2")
    public Collection<Student> findAll2(){
        return restTemplate.getForObject("http://localhost:8010/student/findAll",Collection.class);
    }

    //方法一：当有参数的时候，要把参数写完整，路径也要写完整
    @GetMapping(value = "/findById/{id}")
    public Student findById(@PathVariable("id") long stuId){
        return restTemplate.getForEntity("http://localhost:8010/student/findById/{id}",Student.class,stuId).getBody();
    }

    //放法二
    @GetMapping(value = "/findById2/{id}")
    public Student findById2(@PathVariable("id") long stuId){
        return restTemplate.getForObject("http://localhost:8010/student/findById/{id}",Student.class,stuId);
    }

    //不需要返回值的时候
    @PostMapping(value = "/save")
    public void save(@RequestBody Student student){
        restTemplate.postForEntity("http://localhost:8010/student/save",student,null).getBody();
    }

    @PostMapping(value = "/save2")
    public void save2(@RequestBody Student student){
        restTemplate.postForObject("http://localhost:8010/student/save",student,null);
    }

    @PutMapping(value = "/update")
    public void update(@RequestBody Student student){
        restTemplate.put("http://localhost:8010/student/update",student);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") long stuId){
        restTemplate.delete("http://localhost:8010/student/delete/{id}",stuId);
    }
}
