package com.shutiye.demo.enrollments;

import com.shutiye.demo.student.entities.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class EnrollmentService {
private final StudentCourseRepository studentCourseRepository;

    public EnrollmentService(StudentCourseRepository studentCourseRepository) {
        this.studentCourseRepository = studentCourseRepository;
    }

    public List<Student> getAllStudentsWithCourses() {
        return studentCourseRepository.findAllStudentsWithCourses();
    }

    public List<Student> getStudent( String firstname,  String lastname) {
        return studentCourseRepository.findByFirstNameAndLastName(firstname, lastname);
    }
}
