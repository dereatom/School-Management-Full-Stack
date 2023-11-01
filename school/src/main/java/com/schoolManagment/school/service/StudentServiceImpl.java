package com.schoolManagment.school.service;

import com.schoolManagment.school.entity.Student;
import com.schoolManagment.school.exception.NoResourceFoundException;
import com.schoolManagment.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> getStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(()->new NoResourceFoundException("Student not found with id" +id));

    }

    @Override
    public Student getStudentByStudentFirstName(String studentFirstName) {
        return studentRepository.findStudentByStudentFirstName(studentFirstName)
        .orElseThrow(()->new NoResourceFoundException("Student not found with first name" +studentFirstName));
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long studentId, Student student) {
        Student existingStudent =getStudentById(studentId);
        existingStudent.setStudentFirstName(student.getStudentFirstName());
        existingStudent.setStudentLastName(student.getStudentLastName());
        existingStudent.setStudentUserName(student.getStudentUserName());
        existingStudent.setStudentPassword(student.getStudentPassword());
        existingStudent.setStudentEmail(student.getStudentEmail());

        return studentRepository.save(existingStudent);

    }
    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);

    }
}
