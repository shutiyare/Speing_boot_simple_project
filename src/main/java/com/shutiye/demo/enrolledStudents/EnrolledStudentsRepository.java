package com.shutiye.demo.enrolledStudents;

import com.shutiye.demo.student.entities.Student;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EnrolledStudentsRepository extends CrudRepository <EnrolledStudents,Integer> {

    @Query("SELECT * FROM StudentwithCourses; ")
    Iterable<EnrolledStudents> findAllFromView();

    // Alternatively, you can use a native query if needed
    @Query(value = "SELECT * FROM StudentwithCourses")
    List<EnrolledStudents> findAllFromViewNative();
}
