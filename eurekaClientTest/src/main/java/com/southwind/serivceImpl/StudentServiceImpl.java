package com.southwind.serivceImpl;

import com.southwind.entity.Student;
import com.southwind.service.StudentService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    private static Map<Long,Student> studentMap;

    static {
        studentMap = new HashMap<>();
        studentMap.put(1l,new Student(1l,"张三",20));
        studentMap.put(2l,new Student(2l,"李四",21));
        studentMap.put(3l,new Student(3l,"王五",22));
    }

    @Override
    public Collection<Student> findAll() {

        return studentMap.values();
    }

    @Override
    public Student fingById(long stuId) {

        return studentMap.get(stuId);
    }

    @Override
    public void saveOrupdate(Student student) {
        studentMap.put(student.getStuId(), student);
    }

    @Override
    public void deleteById(long stuId) {
        studentMap.remove(stuId);
    }
}
