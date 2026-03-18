package com.student.portal.service;

import com.student.portal.entity.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(Student std);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student updateStudent(Long id, Student student);

    void deleteStudent(Long id);
}
