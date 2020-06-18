package com.southwind.entity;

import java.io.Serializable;

public class Student implements Serializable {
    private long stuId;
    private String stuName;
    private int age;

    public Student() {
    }

    public Student(long stuId, String stuName, int age) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.age = age;
    }

    public long getStuId() {
        return stuId;
    }

    public void setStuId(long stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", age=" + age +
                '}';
    }
}
