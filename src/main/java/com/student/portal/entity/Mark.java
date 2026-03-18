package com.student.portal.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "marks",
        uniqueConstraints = {
            @UniqueConstraint(
                    columnNames = {"student_id", "subject_id", "exam_id"}
            )
        }
)
public class Mark {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private Integer score;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;
}
