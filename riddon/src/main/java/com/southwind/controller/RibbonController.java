package com.southwind.controller;

import com.southwind.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping(value = "/ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/findAll")
    public Collection<Student> findAll(){
        //这里的因为使用了负载均衡所以url里面的localhost要换成服务提供者的名称
        return restTemplate.getForObject("http://provider/student/findAll",Collection.class);
    }

    @GetMapping(value = "/index")
    public String index(){
        return restTemplate.getForObject("http://provider/student/index",String.class);
    }
}
