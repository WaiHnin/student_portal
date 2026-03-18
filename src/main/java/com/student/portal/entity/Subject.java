package com.student.portal.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "subjects")
public class Subject {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private  String subjectName;

}
