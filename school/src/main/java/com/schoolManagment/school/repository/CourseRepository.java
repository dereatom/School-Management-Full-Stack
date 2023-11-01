package com.schoolManagment.school.repository;

import com.schoolManagment.school.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
//    Course getCourseByID(Long courseId);

    Optional <Course> getCourseByCourseName(String courseName);
}
