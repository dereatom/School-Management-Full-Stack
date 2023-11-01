package com.schoolManagment.school.service;
import com.schoolManagment.school.entity.Instructor;
import com.schoolManagment.school.exception.NoResourceFoundException;
import com.schoolManagment.school.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class InstructorServiceImpl implements InstructorService{
    @Autowired
    private InstructorRepository instructorRepository;
    @Override
    public List<Instructor> getInstructors() {
        return (List<Instructor>) instructorRepository.findAll();
    }

    @Override
    public Instructor getInstructorById(Long instructorId) {
       return instructorRepository.findById(instructorId)
               .orElseThrow(()->new NoResourceFoundException("Instructor not found with id" +instructorId));
    }

    @Override
    public Instructor getInstructorByFirstName(String firstName) {
        return instructorRepository.findByFirstName(firstName)
                .orElseThrow(()->new NoResourceFoundException("Instructor not found with first name" +firstName));
    }

    @Override
    public Instructor saveInstructor(Instructor instructor) {

        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Long instructorId, Instructor instructor) {
        Instructor exsitingInstructor = getInstructorById(instructorId);
        exsitingInstructor.setFirstName(instructor.getFirstName());
        exsitingInstructor.setLastName(instructor.getLastName());
        exsitingInstructor.setUserName(instructor.getUserName());
        exsitingInstructor.setPassword(instructor.getPassword());
        exsitingInstructor.setEmail(instructor.getEmail());
        return instructorRepository.save(exsitingInstructor);

    }

    @Override
    public void deleteInstructor(Long instructorId) {
        instructorRepository.deleteById(instructorId);

    }

}
