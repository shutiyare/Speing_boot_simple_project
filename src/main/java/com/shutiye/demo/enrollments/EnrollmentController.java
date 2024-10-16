package com.shutiye.demo.enrollments;

import com.shutiye.demo.student.entities.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/alldata")
public class EnrollmentController {
    private EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping("/studentsd")
    public List<Student> getStudent(@RequestParam String firstname, @RequestParam String lastname) {
        return enrollmentService.getStudent(firstname,lastname);
    }


    @GetMapping("/students/courses")
    public List<Student> getStudentsWithCourses() {
        return enrollmentService.getAllStudentsWithCourses();
    }
}
