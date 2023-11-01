package com.schoolManagment.school.controller;
import com.schoolManagment.school.entity.Course;
import com.schoolManagment.school.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourses() {
        return new ResponseEntity<>(courseService.getCourses(), HttpStatus.OK);
    }
    @GetMapping("/courses/{courseId}")
    public ResponseEntity getCourseById(@PathVariable Long courseId) {
        return new ResponseEntity<>(courseService.getCourseById(courseId), HttpStatus.OK);
    }
    @GetMapping("/name/{courseName}")
    public ResponseEntity  getCourseByCourseName(String courseName) {
        return new ResponseEntity<>(courseService.getCourseByCourseName(courseName), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity <Course> saveCourse(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.saveCourse(course), HttpStatus.CREATED);
    }
    @PutMapping("/courses/{courseId}")
    public ResponseEntity updateCourse(@PathVariable Long courseId, @RequestBody Course course) {
        return new ResponseEntity<>(courseService.updateCourse(courseId, course), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity <Void> deleteCourse(@PathVariable Long courseId) {
        courseService.deleteCourse(courseId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
