package com.example.studentcrud;

import com.example.studentcrud.entity.Student;
import com.example.studentcrud.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class StudentRepositoryTest {

    @Autowired private StudentRepository studentRepository;

    @Test
    public void testCreateStudent(){
//        Student student = new Student(1l,"","fds","2023-02-12","jpfds.png",100);
//        Student student1=studentRepository.save(student);
//        assertThat(student1).isNotNull();
    }
}
