package com.southwind.service;

import com.southwind.entity.Student;

import java.util.Collection;

public interface StudentService {

    public Collection<Student> findAll();

    public Student fingById(long stuId);

    public void saveOrupdate(Student student);

    public void deleteById(long stuId);
}
