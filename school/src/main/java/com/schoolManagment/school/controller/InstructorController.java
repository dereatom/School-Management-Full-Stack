package com.schoolManagment.school.controller;

import com.schoolManagment.school.entity.Instructor;
import com.schoolManagment.school.service.InstructorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instructor")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;
    @GetMapping("/instructors")
    public ResponseEntity <List<Instructor>> getInstructors() {
        return new ResponseEntity<>(instructorService.getInstructors(), HttpStatus.OK);
    }
    @GetMapping("/{instructorId}")
    public ResponseEntity <Instructor> getInstructorById(@PathVariable Long instructorId) {
        return new ResponseEntity<>(instructorService.getInstructorById(instructorId), HttpStatus.OK);
    }
    @GetMapping("/name/{firstName}")
    public ResponseEntity <Instructor> getInstructorByFirstName(@PathVariable String firstName) {
        return new ResponseEntity<>(instructorService.getInstructorByFirstName(firstName), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity <Instructor> saveInstructor(@RequestBody Instructor instructor) {
        return new ResponseEntity<>(instructorService.saveInstructor(instructor), HttpStatus.CREATED);
    }
    @PutMapping("/{instructorId}")
    public ResponseEntity <Instructor> updateInstructor(@PathVariable Long instructorId, @RequestBody Instructor instructor) {
        return new ResponseEntity<>(instructorService.updateInstructor(instructorId, instructor), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{instructorId}")
    public ResponseEntity <Void> deleteInstructor(@PathVariable Long instructorId) {
        instructorService.deleteInstructor(instructorId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
