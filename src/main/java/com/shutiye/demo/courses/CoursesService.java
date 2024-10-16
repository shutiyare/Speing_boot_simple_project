package com.shutiye.demo.courses;

import com.shutiye.demo.student.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {
    private final CoursesRepository coursesRepository;

    public CoursesService(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }
    public Courses saveCourses (Courses courses){
        System.out.printf("in courses Service -> saveCourses : %s \n", courses);
        return coursesRepository.save(courses);

    }

    public List<Courses> getAllCourses(){
        System.out.printf("in Courses Services -> getCourses ");

        return (List<Courses> )coursesRepository.findAll();
    }

    public Courses getCourse(int courseId) {
        System.out.printf("in Course Service -> getSingle Course: %s \n", courseId);
        return coursesRepository.findById(courseId).orElse(null);
    }

    public Courses updateCourses(int courseid,Courses updatedCourse){
        if (!coursesRepository.existsById(courseid)) {
            throw new IllegalArgumentException("Course with ID " + courseid + " does not exist.");
        }
        updatedCourse.setCourseid(courseid);
        return coursesRepository.save(updatedCourse);
    }

    public void deleteCourse(int courseId){
        if (!coursesRepository.existsById(courseId)) {
            throw new IllegalArgumentException("Student with ID " + courseId + " does not exist.");
        }
         coursesRepository.deleteById(courseId);
    }

}
