package com.student.portal.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "admins")
public class Admin extends User{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String adminLevel;
}
