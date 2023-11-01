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
		for(int j = 0;j<20;j++){
			course = new Course();
			course.setCourseName(myFaker.educator().course());
			course.setCourseCode(myFaker.educator().course());
			course.setStudents(new HashSet<>(Arrays.asList(

                    studentRepository.findAll().get(j%5)
            )));
			course.setInstructor(new HashSet<>(Arrays.asList(
                    instructorRepository.findAll().get(j%5)
            )));

			courseRepository.save(course);


//			if(j%3==0){
//				course.setInstructor(new HashSet<>(Arrays.asList(instructors.get(2))));
//
//			}else if(j%2==0){
//				course.setInstructor(new HashSet<>(Arrays.asList(
//						instructors.get(1)
//				)));
//			}else {
//				course.setInstructor(new HashSet<>(Arrays.asList(instructors.get(0))));
//			}
			;
		}
	}
//	@Override
//	public void run(String... args) throws Exception {
//		Course course = new Course(1L, "Java", "J101");
//		Course course1 = new Course(2L, "Spring Boot", "SB101");
//		Course course2 = new Course(3L, "HTML", "H101");
//		Course course3 = new Course(4L, "Spring Security", "SS101");
//
//		List<Course> coursesList = Arrays.asList(
//				courseRepository.save(course),
//				courseRepository.save(course1),
//				courseRepository.save(course2),
//				courseRepository.save(course3));
//		courseRepository.saveAll(coursesList);
//		Instructor instructor1 = new Instructor(1L, "Abebe", "Kebede", "abebekebede", "123456", "abebekebede@gmail.com");
//		Instructor instructor2 = new Instructor(2L, "Sara", "Own", "saraown", "123456", "saraown@gmail.com");
//		Instructor instructor3 = new Instructor(3L, "John", "Doe", "johndoe", "123456", "johndoe@gmail.com");
//		Instructor instructor4 = new Instructor(4L, "Adam", "Shar", "ademshar", "123456", "ademshar@gmail.com");
//		List<Instructor> instructors = Arrays.asList(
//                instructorRepository.save(instructor1),
//                instructorRepository.save(instructor2),
//                instructorRepository.save(instructor3),
//                instructorRepository.save(instructor4));
//		instructorRepository.saveAll(instructors);
//
//		List<Student> students = Arrays.asList(
//				new Student(1L, "John", "Smith", "johnsmith", "1234567890", "johnsmith@gmail.com"),
//				new Student(2L, "Jane", "Doe", "janedoe", "1234567890", "janedoe@gmail.com"),
//				new Student(3L, "Mary", "Smith", "marysmith", "1234567890", "marysmith@hotmail.com"),
//				new Student(4L, "John", "Doe", "johndoe", "1234567890", "johndoe@email.com"),
//				new Student(5L, "Jane", "Smith", "janesmith", "1234567890", "janesmith@gmail.com")
//				);
//		studentRepository.saveAll(students);
//		studentRepository.findAll().forEach(student->logger.info(student.getStudentFirstName() +" " +student.getStudentLastName()));
//	}
}

