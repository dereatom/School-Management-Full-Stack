package com.schoolManagment.school.service;

import com.schoolManagment.school.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> getCourses();

    Course getCourseById(Long courseId);

    Course getCourseByCourseName(String courseName);

    Course saveCourse(Course course);

    Course updateCourse(Long courseId, Course course);

    void deleteCourse(Long courseId);
}
