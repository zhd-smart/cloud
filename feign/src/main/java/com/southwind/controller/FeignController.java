package com.southwind.controller;

import com.netflix.discovery.converters.Auto;
import com.southwind.entity.Student;
import com.southwind.feign.FeignProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "/feign")
public class FeignController {

    @Autowired
    private FeignProviderClient feignProviderClient;

    @GetMapping(value = "/findAll")
    public Collection<Student> findAll(){
        return feignProviderClient.findAll();
    }

    @GetMapping(value = "/index")
    public String index(){
        return feignProviderClient.index();
    }
}
