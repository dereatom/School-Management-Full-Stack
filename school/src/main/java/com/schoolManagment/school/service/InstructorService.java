package com.schoolManagment.school.service;

import com.schoolManagment.school.entity.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> getInstructors();

    Instructor getInstructorById(Long instructor_id);

    Instructor getInstructorByFirstName(String firstName);

    Instructor saveInstructor(Instructor instructor);

    Instructor updateInstructor(Long instructor_id, Instructor instructor);

    void deleteInstructor(Long instructor_id);
}
