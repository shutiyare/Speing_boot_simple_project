package com.shutiye.demo.student.controller;
import com.shutiye.demo.student.entities.Student;
import com.shutiye.demo.student.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody @Valid Student newStudent){
        return new ResponseEntity<>(studentService.saveStudent(newStudent), HttpStatus.CREATED);
    }
    @GetMapping("/{studentid}")
    public ResponseEntity<Student> getStudent(@PathVariable Long studentid){
        return new ResponseEntity<>(studentService.getStudent(studentid), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students=studentService.getAllStudents();
        if (students.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(students);
//        return new ResponseEntity<>(studentService.getStudent(studentId), HttpStatus.OK);
    }

    @PutMapping("/{studentid}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentid, @RequestBody Student updatedStudent) {
        try {
            Student student = studentService.updateStudent(studentid, updatedStudent);
            return ResponseEntity.ok(student);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{studentid}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentid) {
        try {
            studentService.deleteStudent(studentid);
            return ResponseEntity.noContent().build(); // Return 204 No Content on successful deletion
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // Return 404 Not Found if the student does not exist
        }
    }


}
