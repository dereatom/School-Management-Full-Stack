package com.schoolManagment.school.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;

import java.util.List;
import java.util.Set;

@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instructor_id;
    private String firstName, lastName,userName, password, email;
    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name="registered_course",joinColumns = { @JoinColumn(name="instructor_id") },
            inverseJoinColumns = {
                    @JoinColumn(name = "id")
            })
    private Set<Course> courses = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    @JsonIgnore
    private List<Student> students;

    public Instructor() {}

    public Instructor(Long instructor_id, String firstName, String lastName, String userName, String password, String email) {
        this.instructor_id = instructor_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public Instructor(String firstName, String lastName, String userName, String password, String email, Set<Course> courses, List<Student> students) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.courses = courses;
        this.students = students;
    }

    public Long getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(Long instructor_id) {
        this.instructor_id = instructor_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
