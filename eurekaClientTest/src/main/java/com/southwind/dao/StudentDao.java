package com.southwind.dao;

import com.southwind.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface StudentDao {

    public Collection<Student> findAll();

    public Student fingById(long stuId);

    public void saveOrupdate(Student student);

    public void deleteById(long stuId);
}
