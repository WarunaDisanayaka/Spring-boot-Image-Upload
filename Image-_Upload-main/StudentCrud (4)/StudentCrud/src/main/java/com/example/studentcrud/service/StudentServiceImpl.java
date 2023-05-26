package com.example.studentcrud.service;

import com.example.studentcrud.entity.Student;
import com.example.studentcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements  StudentService{

    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();

    }

    @Override
    public Student saveStudent(Student student) {

        return  studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return null;
    }

    @Override
    public Student updateStudent(Student student) {
        return null;
    }

    @Override
    public void deleteStudentById(Long id) {

    }


}
