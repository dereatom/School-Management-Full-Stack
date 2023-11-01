package com.schoolManagment.school;

import com.github.javafaker.Faker;
import com.schoolManagment.school.entity.Course;
import com.schoolManagment.school.entity.Instructor;
import com.schoolManagment.school.entity.Student;
import com.schoolManagment.school.repository.CourseRepository;
import com.schoolManagment.school.repository.InstructorRepository;
import com.schoolManagment.school.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class SchoolApplication implements CommandLineRunner{
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private InstructorRepository instructorRepository;
	@Autowired
	private CourseRepository courseRepository;
private static final Logger logger =(Logger) LoggerFactory.getLogger(SchoolApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(SchoolApplication.class, args);
		logger.info("School Application Started");
	}
		@Override
	public void run(String... args) throws Exception {
		Faker myFaker = new Faker();
		myFaker.educator().course();

		Course course;
		Student student;
		Instructor instructor;
		List<Instructor> instructors = instructorRepository.findAll();
		for(int i = 0;i<5;i++){
			student = new Student();
			student.setStudentFirstName(myFaker.name().firstName());
			student.setStudentLastName(myFaker.name().lastName());
			student.setStudentEmail(myFaker.internet().emailAddress());
			student.setStudentUserName(myFaker.name().username());
			student.setStudentPassword(myFaker.internet().password());

			studentRepository.save(student);
		}
		for (int i=0;i<10;i++){
			instructor = new Instructor();
            instructor.setFirstName(myFaker.name().firstName());
            instructor.setLastName(myFaker.name().lastName());
            instructor.setUserName(myFaker.name().username());
            instructor.setPassword(myFaker.internet().password());
            instructor.setEmail(myFaker.internet().emailAddress());
            instructorRepository.save(instructor);
		}
		for(int j = 0;j<20;j++) {
			course = new Course();
			course.setCourseName(myFaker.educator().course());
			course.setCourseCode(myFaker.educator().course());
			course.setStudents(new HashSet<>(Arrays.asList(

					studentRepository.findAll().get(j % 5)
			)));
			course.setInstructor(new HashSet<>(Arrays.asList(
					instructorRepository.findAll().get(j % 5)
			)));

			courseRepository.save(course);
		}
	}
}

