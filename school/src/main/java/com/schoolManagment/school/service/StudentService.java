package com.schoolManagment.school.service;

import com.schoolManagment.school.entity.Student;

import java.util.List;

public interface StudentService {

     List<Student> getStudents();

     Student getStudentById(Long id);

     Student getStudentByStudentFirstName(String studentFirstName);

     Student saveStudent(Student student);

     Student updateStudent(Long id, Student student);

     void deleteStudent(Long id);
}
