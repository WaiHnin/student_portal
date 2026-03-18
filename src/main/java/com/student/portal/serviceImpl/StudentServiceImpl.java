package com.student.portal.serviceImpl;

import com.student.portal.entity.Student;
import com.student.portal.exception.ResourceNotFoundException;
import com.student.portal.repository.StudentRepository;
import com.student.portal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository stdRepository;

    public StudentServiceImpl(StudentRepository stdRepository) {
        this.stdRepository = stdRepository;
    }

    @Override
    public Student createStudent(Student std) {
        return stdRepository.save(std);
    }

    @Override
    public List<Student> getAllStudents() {
        return stdRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return stdRepository.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        return stdRepository.findById(id)
                .map(existingStudent -> {
                    existingStudent.setRollNumber(student.getRollNumber());
                    existingStudent.setStdName(student.getStdName());
                    existingStudent.setClassEntity(student.getClassEntity());
                    return stdRepository.save(existingStudent);
                })
                .orElseThrow(() ->new ResourceNotFoundException("Student of id "+id+" not found"));
                //.orElse(null);
    }

    @Override
    public void deleteStudent(Long id) {
        stdRepository.deleteById(id);
    }
}
