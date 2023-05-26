package com.example.studentcrud.service;

import com.example.studentcrud.entity.Student;

public interface StudentService {


    Iterable<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudentById(Long id);

    Student updateStudent(Student student);

    void deleteStudentById(Long id);

}
