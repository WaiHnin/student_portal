## Student Portal Application
This is a Spring Boot-based Student Portal Application that provides APIs for managing student data with authentication and authorization.

## Tech Stack
- Java 
- Spring Boot
- Spring Security (JWT)
- Spring Data JPA (Hibernate)
- MySQL
- Maven

---

## Security
- JWT-based authentication
- Role-based authorization (ADMIN, USER)
- Protected APIs using Spring Security

---

## Project Structure
- `src/` → Source code
- `docs/` → Project documents and API details
- `pom.xml` → Maven dependencies

---

## Before to Run the Project
- Create the database
CREATE DATABASE student_portal;
show databases;

- Insert one row for Classes table
INSERT INTO classes (id, class_name) VALUES (1, 'Class 1');

## Default Admin User
Username: admin
Password: admin123
