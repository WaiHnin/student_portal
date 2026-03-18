package com.student.portal.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "exams")
public class Exam {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String examName;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity classEntity;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
