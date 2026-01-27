package org.example.demo_springmvc.service;

import org.example.demo_springmvc.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(int id);
    boolean add(Student student);

}
