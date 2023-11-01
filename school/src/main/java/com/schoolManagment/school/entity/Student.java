package com.schoolManagment.school.entity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id;
    private String studentFirstName, studentLastName, studentUserName, studentPassword, studentEmail;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "registered_course", joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "id")
            })
    private Set<Course> course = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor")
    private Instructor instructor;

//    private Set<Instructor> instructor = new HashSet<>();

    public Student() {
    }

    public Student(Long student_id, String studentFirstName, String studentLastName, String studentUserName, String studentPassword, String studentEmail) {
        this.student_id = student_id;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentUserName = studentUserName;
        this.studentPassword = studentPassword;
        this.studentEmail = studentEmail;
    }

    public Student(String studentFirstName, String studentLastName, String studentUserName, String studentPassword, String studentEmail, Set<Course> course, Instructor instructor) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentUserName = studentUserName;
        this.studentPassword = studentPassword;
        this.studentEmail = studentEmail;
        this.course = course;
        this.instructor = instructor;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentUserName() {
        return studentUserName;
    }

    public void setStudentUserName(String studentUserName) {
        this.studentUserName = studentUserName;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public Set<Course> getCourse() {
        return course;
    }

    public void setCourse(Set<Course> course) {
        this.course = course;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}