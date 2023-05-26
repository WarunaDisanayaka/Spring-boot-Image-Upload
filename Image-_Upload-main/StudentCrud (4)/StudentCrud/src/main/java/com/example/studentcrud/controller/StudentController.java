package com.example.studentcrud.controller;

import com.example.studentcrud.entity.Student;
import com.example.studentcrud.service.StudentService;
import com.example.studentcrud.service.StudentServiceImpl;
import com.example.studentcrud.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller

public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;



    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";

    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {

        // create student object to hold student form data
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";

    }

    @PostMapping("/students")
    public String saveStudent(Student student,@RequestParam("image") MultipartFile multipartFile) throws IOException {
        if (!multipartFile.isEmpty()){
            String filename= StringUtils.cleanPath(multipartFile.getOriginalFilename());
            student.setImageName(filename);
            Student student1=studentService.saveStudent(student);
            String upload="images/"+student.getId();

            FileUploadUtil.saveFile(upload,filename,multipartFile);
        }else{
            if (student.getImageFile().isEmpty()){
                student.setImageFile(null);
                studentService.saveStudent(student);
            }
        }
        studentService.saveStudent(student);

        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

//    @PostMapping("/students/{id}")
//    public String updateStudent(@PathVariable Long id,
//                                @ModelAttribute("student") Student student,
//                                Model model) {
//
//        // get student from database by id
//        Student existingStudent = studentService.getStudentById(id);
//        existingStudent.setId(id);
//        existingStudent.setVehicle_id(student.getVehicle_id());
//        existingStudent.setDescription(student.getDescription());
//        existingStudent.setDamage_date(student.getDamage_date());
//        existingStudent.setImage(student.getImage());
//        existingStudent.setAmount(student.getAmount());
//
//
//        // save updated student object
//        studentService.updateStudent(existingStudent);
//        return "redirect:/students";
//    }

    // handler method to handle delete student request

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }


}
