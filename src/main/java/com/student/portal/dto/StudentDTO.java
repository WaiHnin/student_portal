package com.student.portal.dto;

import lombok.Data;

@Data
public class StudentDTO {
    private Long id;
    private String stdName;
    private String rollNumber;
    private Long classId;
}
