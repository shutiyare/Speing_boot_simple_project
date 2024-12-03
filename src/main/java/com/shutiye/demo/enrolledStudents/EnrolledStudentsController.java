package com.shutiye.demo.enrolledStudents;

import com.shutiye.demo.student.entities.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/enrolledStudents")
public class EnrolledStudentsController {
    private final EnrolledStudentsService enrolledStudentsService;

    public EnrolledStudentsController(EnrolledStudentsService enrolledStudentsService) {
        this.enrolledStudentsService = enrolledStudentsService;
    }
    @GetMapping
    public ResponseEntity<Iterable<EnrolledStudents>> getAllStudents(){

        Iterable<EnrolledStudents> students=enrolledStudentsService.getAllEnrolledStudents();
//        if (students.iterator()){
//            return ResponseEntity.noContent().build();
//        }
        return ResponseEntity.ok(students);
//        return new ResponseEntity<>(studentService.getStudent(studentId), HttpStatus.OK);
    }

}
