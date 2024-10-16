package com.shutiye.demo.courses;

import com.shutiye.demo.student.entities.Student;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {
    private final CoursesService coursesService;

    public CoursesController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

//    Create new Course
    @PostMapping
    public Courses createNewCourse (@RequestBody @Valid Courses courses){
        return new ResponseEntity<>(coursesService.saveCourses(courses), HttpStatus.CREATED).getBody();
    }

//    Get All Courses
    @GetMapping
    public ResponseEntity<List<Courses>> getAllCourses(){
        List<Courses> courses=coursesService.getAllCourses();
        if (courses.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(courses);
    }

//    GEt Single Course
    @GetMapping("/{courseId}")
    public ResponseEntity<Courses> getCourse(@PathVariable int courseId){
        return new ResponseEntity<>(coursesService.getCourse(courseId),HttpStatus.OK);
    }

//    Update Course
@PutMapping("/{courseId}")
public ResponseEntity<Courses> updateCourse(@PathVariable int courseId, @RequestBody Courses updatedStudent) {
    try {
        Courses courses = coursesService.updateCourses(courseId, updatedStudent);
        return ResponseEntity.ok(courses);
    } catch (IllegalArgumentException e) {
        return ResponseEntity.notFound().build();
    }
}

//Delete course
    @DeleteMapping("{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable int   courseId) {
        try {
            coursesService.deleteCourse(courseId);
            return ResponseEntity.noContent().build(); // Return 204 No Content on successful deletion
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // Return 404 Not Found if the student does not exist
        }
    }
}
