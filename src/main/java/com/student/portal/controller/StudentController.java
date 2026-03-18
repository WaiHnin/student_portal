package com.student.portal.controller;

import com.student.portal.dto.StudentDTO;
import com.student.portal.entity.Student;
import com.student.portal.exception.ResourceNotFoundException;
import com.student.portal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService stdService;

    @PostMapping("/createStudent")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Student createStudent(@RequestBody Student student){
        return stdService.createStudent(student);
    }

    @GetMapping("/getAllStudents")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public List<StudentDTO> getAllStudents() {
        return stdService.getAllStudents().stream().map(student -> {
            StudentDTO dto = new StudentDTO();
            dto.setId(student.getId());
            dto.setRollNumber(student.getRollNumber());
            dto.setStdName(student.getStdName());
            dto.setClassId(student.getClassEntity().getId());
            return dto;
        }).toList();
    }

    @GetMapping("/getStudentById/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public Student getStudentById(@PathVariable Long id){
        return stdService.getStudentById(id);
    }

    @PostMapping("/updateStudent/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student){
        try {
            Student updatedStudent = stdService.updateStudent(id, student);
            return ResponseEntity.ok(updatedStudent);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of(
                            "status", 404,
                            "message", ex.getMessage()));
        }
    }

    @GetMapping("/deleteStudent/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String deleteStudent(@PathVariable Long id){
        stdService.deleteStudent(id);
        return "Student deleted successfully";
    }

}
