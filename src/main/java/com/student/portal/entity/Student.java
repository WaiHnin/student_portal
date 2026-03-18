package com.student.portal.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "std_name")
    private String stdName;

    @Column(name = "roll_number")
    private String rollNumber;

    @ManyToOne
    @JoinColumn(name = "class_id")
    @JsonIgnoreProperties({"students"})
    private ClassEntity classEntity;
}
