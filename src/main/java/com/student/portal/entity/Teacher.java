package com.student.portal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table (name = "teachers")
public class Teacher extends User{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String teacherName;

    private String teacherCode;

    @ManyToMany
    @JoinTable(
            name = "teacher_classes",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id")
    )
    private List<ClassEntity> classes;

    @ManyToMany
    @JoinTable(
            name = "teacher_subjects",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")

    )
    private List<Subject> subjects;
}
