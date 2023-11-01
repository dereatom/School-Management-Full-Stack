package com.schoolManagment.school.entity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long course_id;
    private String courseName;
    private String courseCode;
    @ManyToMany(mappedBy = "course")
    private Set<Student> students = new HashSet<>();
    @ManyToMany
    private Set<Instructor> instructor = new HashSet<>();


    public Course() {}

    public Course(Long course_id, String courseName, String courseCode) {
        this.course_id = course_id;
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public Course(String courseName, String courseCode, Set<Student> students, Set<Instructor> instructor) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.students = students;
        this.instructor = instructor;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Instructor> getInstructor() {
        return instructor;
    }

    public void setInstructor(Set<Instructor> instructor) {
        this.instructor = instructor;
    }
}
