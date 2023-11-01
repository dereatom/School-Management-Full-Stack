package com.schoolManagment.school.service;
import com.schoolManagment.school.entity.Course;
import com.schoolManagment.school.exception.NoResourceFoundException;
import com.schoolManagment.school.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long CourseId) {
        return courseRepository.getById(CourseId);
    }

    @Override
    public Course getCourseByCourseName(String courseName) {
        return courseRepository.getCourseByCourseName(courseName)
                .orElseThrow(()->new NoResourceFoundException("Course not found with Course Name" +courseName));
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long courseId, Course course) {
        Course existingCourse = getCourseById(courseId);
        existingCourse.setCourseName(course.getCourseName());
        existingCourse.setCourseCode(course.getCourseCode());
        return courseRepository.save(existingCourse);

    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);

    }
}
